import java.util.Scanner;
import java.io.File;
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
		File file = new File("/Files/dictionary-algs4.txt");
		String[] words = new String[0];
		try {
			Scanner scan = new Scanner(file);
			words = scan.nextLine().split("\n");
		} catch (Exception e) {
			System.out.println("Exception!");
		}
		return words;
	}
}