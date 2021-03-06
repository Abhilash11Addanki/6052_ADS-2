import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		String[] res = toReadFile(file);
		for (String s : res) {
			if (st.contains(s.toLowerCase())) {
				st.put(s.toLowerCase(), st.get(s.toLowerCase()) + 1);
			} else {
				st.put(s.toLowerCase(), 1);
			}
		}
		return st;
	}

}

class T9 {
	TST<Integer> tst;
	BinarySearchST<String, Integer> st;
	TopK t;
	MaxPQ<TopK> pq;
	HashMap<String, String> map;
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		this.st = st;
		tst = new TST();
		for (String s : st.keys()) {
			tst.put(s, st.get(s));
		}
	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here
		return tst.keysWithPrefix(prefix);
	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		map = new HashMap<String, String>();
		//Mapping the alphabets to numbers.
	 	map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        String[] arr = t9Signature.split("");
		ArrayList<String> al1 = new ArrayList<String>();
        ArrayList<String> al2 = new ArrayList<String>();
        al1.add("");
        for (String s : arr) {
            for (String str : al1) {
                String alpha = map.get(s);
                String[] alphaarr = alpha.split("");
                for (String st : alphaarr) {
                    al2.add(str + st);
                }
            }
            al1 = al2;
            al2 = new ArrayList<String>();
        }
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0; i < al1.size(); i++) {
        	if(tst.contains(al1.get(i))) {
        		res.add(al1.get(i));
        	}
        }
		return res;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		pq = new MaxPQ<TopK>();
		Queue<String> queue = new Queue<String>();
		for (String s : words) {
			t = new TopK(s, st.get(s));
			pq.insert(t);
		}
		String[] temp = new String[k];
		for(int i = 0; i < k; i++) {
			TopK n = pq.delMax();
			temp[i] = n.getWord();
		}
		Arrays.sort(temp);
		for (String s: temp) {
            queue.enqueue(s);
		}
		return queue;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
