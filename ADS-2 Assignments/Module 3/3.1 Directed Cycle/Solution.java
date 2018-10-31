import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Digraph d = new Digraph(scan);
		DirectedCycle dc = new DirectedCycle(d);
		System.out.println(dc.hasCycle());
	}
}