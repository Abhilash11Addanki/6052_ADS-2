import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * graph as g.
	 */
	private Digraph gr;
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
	private Double[] pr;
	/**
	 * constructor.
	 *
	 * @param      gph    The graphics
	 */
	PageRank(final Digraph gr) {
		this.gr = gr;
		this.revdg = gr.reverse();
		this.vertices = gr.vertices();
		pr = new Double[vertices];
		int ver = gr.vertices();
		for (int i = 0; i < vertices; i++) {
			pr[i] = 1.0 / ver;
		}
		prCalculation();
	}
	/**.
	 * method to calculate the page Rank
	 */
	public void prCalculation() {
		for (int i = 0; i < vertices; i++) {
			if (gr.outdegree(i) == 0) {
				for (int j = 0; j < vertices; j++) {
					if (i != j) {
						gr.addEdge(i, j);
					}
				}
			}
		}
		final int thousand = 1000;
		for (int k = 1; k < thousand; k++) {
			Double[] temppr = new Double[vertices];
			for (int i = 0; i < vertices; i++) {
				Double newpr = 0.0;
				for (int ele : gr.reverse().adj(i)) {
					newpr = newpr
					        + pr[ele] / gr.outdegree(ele);
				}
				temppr[i] = newpr;
			}
			pr = temppr;
		}
	}
	/**.
	 * method to get the page rank for the given page rank
	 *
	 * @param      v     { vertices of type int }
	 *
	 * @return     The page rank.
	 */
	public Double getPageRank(final int v) {
		return pr[v];
	}
	/**.
	 * method to printer
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < vertices; i++) {
			s += i + " - " + pr[i] + "\n";
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
