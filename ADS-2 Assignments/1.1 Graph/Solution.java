import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		Graph gobj = new Graph(scan);
		System.out.println(gobj);
	}
}
