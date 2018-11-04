import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * graph as g.
	 */
	private Digraph dg;
	/**
	 * reverse of the given graph as revG.
	 */
	private Digraph revdg;
	/**
	 * variable for vertices.
	 */
	private int vertices;
	/**
	 * array to store the pageRanks.
	 */
	private Double[] pagerank;
	private Double[] temppagerank;
	/**
	 * constructor.
	 *
	 * @param      gph    The graphics
	 */
	PageRank(final Digraph d) {
		dg = d;
		revdg = dg.reverse();
		vertices = dg.vertices();
		pagerank = new Double[vertices];
		for (int i = 0; i < vertices; i++) {
			pagerank[i] = 1.0 / vertices;
		}
		for (int i = 0; i < vertices; i++) {
			if (dg.outdegree(i) == 0) {
				for (int j = 0; j < vertices; j++) {
					if (i != j) {
						dg.addEdge(i, j);
					}
				}
			}
		}
		final int thousand = 1000;
		for (int iter = 1; iter < thousand; iter++) {
			temppagerank = new Double[vertices];
			for (int i = 0; i < vertices; i++) {
				Double newpr = 0.0;
				for (Integer ele : revdg.adj(i)) {
					newpr = newpr + pagerank[ele] / dg.outdegree(ele);
				}
				temppagerank[i] = newpr;
			}
			pagerank = temppagerank;
		}
	}
	/**.
	 * method to get the page rank for the given page rank
	 *
	 * @param      v     { vertices of type int }
	 *
	 * @return     The page rank.
	 */
	public Double getPR(final int v) {
		return pagerank[v];
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < dg.vertices(); i++) {
			s += i + " - " + pagerank[i] + "\n";
		}
		return s;
	}
}
/**
 * Class for web search.
 */
class WebSearch {

}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
	}
	/**
	 * main method that drives the program.
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		// read the first line of the input to get the number of vertices
		int n = Integer.parseInt(sc.nextLine());
		Digraph d = new Digraph(n);
		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph
		for (int i = 0; i < n; i++) {
			String[] inp = sc.nextLine().split(" ");
			for (int j = 1; j < inp.length; j++) {
				d.addEdge(Integer.parseInt(inp[0]),
				          Integer.parseInt(inp[j]));
			}
		}
		System.out.println(d);
		// Create page rank object and pass the graph object to the constructor
		PageRank p = new PageRank(d);
		// print the page rank object
		System.out.println(p);
		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
