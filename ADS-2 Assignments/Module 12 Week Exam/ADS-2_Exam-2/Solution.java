import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner scan = new Scanner(System.in);

		int cities = scan.nextInt();
		scan.nextLine();
		int roadLines = scan.nextInt();
		scan.nextLine();
		EdgeWeightedGraph graph = new EdgeWeightedGraph(cities);

		for(int i = 0; i < roadLines; i++) {
			String[] paths = scan.nextLine().split(" ");
			int cityA = Integer.parseInt(paths[0]);
			int cityB = Integer.parseInt(paths[1]);
			int distance = Integer.parseInt(paths[2]);

			graph.addEdge(new Edge(cityA, cityB, distance));

		}

		String caseToGo = scan.nextLine();

		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(graph);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}
