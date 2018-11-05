import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {
    /**
     * graph as g.
     */
    private Digraph dg;
    /**
     * variable for vertices.
     */
    private int vertices;
    /**
     * array to store the pageRanks.
     */
    private Double[] pagerank;
    /**
     * temp array to store the page ranks.
     */
    private Double[] temppagerank;
    /**
     * constructor.
     * @param      d    d of type Digraph
     * Time complexity for this method is V*(V + E).
     */
    PageRank(final Digraph d) {
        dg = d;
        vertices = dg.vertices();
        pagerank = new Double[vertices];
        temppagerank = new Double[vertices];
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
        for (int k = 1; k < thousand; k++) {
            for (int i = 0; i < vertices; i++) {
                temppagerank[i] = pagerank[i];
                pagerank[i] = 0.0;
            }
            for (int j = 0; j < vertices; j++) {
                for (int ele : dg.reverse().adj(j)) {
                    pagerank[j] += temppagerank[ele]
                    / dg.outdegree(ele);
                }
            }
        }
    }
    /**
     * Gets the page rank.
     * @param      v     vertex.
     * @return     The page rank.
     * Time complexity for this method is O(1).
     */
    public Double getPageRank(final int v) {
        return pagerank[v];
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     * Time complexity for this method is O(v) where v
     * is vertices.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < vertices; i++) {
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
     * Time complexity for this method is O(N * i) where N is the no of vertices
     * and i is the length of inp array.
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

