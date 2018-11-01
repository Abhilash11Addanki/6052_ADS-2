import java.util.Scanner;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String synsets = sc.nextLine();
		File file = new File("Files\\" + synsets);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}