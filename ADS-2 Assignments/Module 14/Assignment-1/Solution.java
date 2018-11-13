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
		String[] arr = new String[1000];
		int i = 0;
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				arr[i] = scan.nextLine();
				i++;
			}
		} catch (Exception e) {
			System.out.println("Exception!");
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
}