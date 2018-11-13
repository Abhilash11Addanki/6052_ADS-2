import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		TST<Integer> t = new TST();
		String[] words = loadWords();
		//Your code goes here...
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				t.put(words[i].substring(j), flag);
				flag++;
			}
		}
		for (String res : t.keysWithPrefix(sc.nextLine())) {
			System.out.println(res);
		}
	}

	public static String[] loadWords() {
		File file = new File("Files/dictionary-algs4.txt");
		String[] res = new String[0];
		try {
			Scanner scan = new Scanner(file);
			String[] words = scan.nextLine().split("\n");
			res = Arrays.copyOf(words, words.length);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
}