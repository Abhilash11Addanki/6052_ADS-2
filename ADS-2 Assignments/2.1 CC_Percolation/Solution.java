import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		Percolation p = new Percolation(vertices);
		while (sc.hasNext()) {
			p.open(sc.nextInt() - 1, sc.nextInt() - 1);
		}
		System.out.println(p.percolates());
	}
}
