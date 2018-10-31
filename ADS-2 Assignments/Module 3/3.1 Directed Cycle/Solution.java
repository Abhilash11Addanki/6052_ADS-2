import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		Digraph d = new Digraph(vertices);
		for (int i = 0; i < edges; i++) {
			String[] inp = sc.nextLine().split(" ");
			d.addEdge(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
		}
		DirectedCycle dc = new DirectedCycle(d);
		if (dc.hasCycle()) {
			System.out.println("Cycle exists.");
		} else {
			System.out.println("Cycle doesn't exists.");
		}
	}
}
