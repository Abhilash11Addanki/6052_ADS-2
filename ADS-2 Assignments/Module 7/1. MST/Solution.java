import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph wg = new EdgeWeightedGraph(vertices);
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]),
				Double.parseDouble(line[2]));
			wg.addEdge(e);
		}
		KruskalMST k = new KruskalMST(wg);
		System.out.format("%.5f", k.weight());
	}
}
