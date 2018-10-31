import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		Graph g = new Graph(vertices);
		for (int i = 0; i < edges; i++) {
			String[] inp = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
		}
		Bipartite b = new Bipartite(g);
		if (b.isBipartite()) {
			System.out.println("Graph is bipartite");
		} else {
			System.out.println("Graph is not a bipartite");
		}
	}
}
