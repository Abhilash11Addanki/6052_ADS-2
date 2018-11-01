import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String synsets = sc.nextLine();
		String hypernyms = sc.nextLine();
		File file = new File("Files\\" + synsets);
		HashMap<Integer, String> synsetshm = new HashMap<Integer, String>();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String[] inp = scan.nextLine().split(",");
				synsetshm.put(Integer.parseInt(inp[0]), inp[1]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (Map.Entry m : synsetshm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
}