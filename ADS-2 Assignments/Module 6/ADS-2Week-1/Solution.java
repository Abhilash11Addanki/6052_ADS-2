import java.util.Scanner;
class PageRank {
	private Digraph dg;
	private double pagerank;
	PageRank(final Digraph d) {
		dg = d;
		pagerank = 1 / 4;
	}
	double getPR(int v) {
		pagerank = 0;
		for (Integer i : dg.adj(v)) {
			pagerank += getPR(i) / dg.outdegree(v);
		}
		return pagerank;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int v = 0; v < dg.V(); v++) {
			s.append(String.format("%d - ", v));
			s.append(String.format("%d ", getPR(v)));
			s.append("\n");
		}
		return s.toString();
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
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
				d.addEdge(Integer.parseInt(inp[0]), Integer.parseInt(inp[j]));
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
