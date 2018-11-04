import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * dg of type Digraph.
	 */
	private Digraph dg;
	/**
	 * Constructs the object.
	 * @param      d     Digraph.
	 */
	PageRank(final Digraph d) {
		dg = d;
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
		// print the page rank object
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
