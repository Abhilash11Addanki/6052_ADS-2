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
     * pagerank of type double array.
     */
    private double[] pagerank;
    /**
     * temppagerank of type double array.
     */
    private double[] temppagerank;
    /**
     * initpagerank of type double.
     */
    private double initpagerank;
    /**
     * k for iterating.
     */
    private int k = 0;
    /**
     * Constructs the object.
     * @param      d     Digraph.
     */
    PageRank(final Digraph d) {
        dg = d;
        pagerank = new double[dg.V()];
        initpagerank = 1 / dg.V();
        temppagerank = new double[dg.V()];
        for (k = 0; k < dg.V(); k++) {
            this.pagerank[k] = initpagerank;
        }
        int iteration = 0;
        while (iteration <= 1000) {
            for (k = 0; k < dg.V(); k++) {
                temppagerank[k] = this.pagerank[k];
                this.pagerank[k] = 0;
            }
            for (int a = 0; a < dg.V(); a++) {
                for (int b = 0; b < dg.V(); b++) {
                    this.pagerank[a] += temppagerank[b]
                    / dg.outdegree(b);
                }
            }
            iteration++;
        }
    }
    /**
     * Gets the pr.
     * @param      v     vertex.
     * @return     The pr.
     */
    double getPR(final int v) {
        return pagerank[v];
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < dg.V(); v++) {
            s.append(String.format("%d - ", v));
            s.append(String.format("%f ", getPR(v)));
            s.append("\n");
        }
        return s.toString();
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
