import java.util.Scanner;
import java.util.HashMap;
/**
 *class for solution.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method is to read the user.
     * input.
     *time complexity is O(E + V)
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> map
        = new HashMap<String, Integer>();
        String[] tokens = scan.nextLine().split(" ");
        int edges = Integer.parseInt(tokens[1]);
        String[] vertices = scan.nextLine().split(" ");
        for (int i = 0; i < vertices.length; i++) {
            map.put(vertices[i], i);
        }
        Edge edgeObj;
        EdgeWeightedGraph digraph
        = new EdgeWeightedGraph(vertices.length);
        for (int i = 0; i < edges; i++) {
            String[] directPath = scan.nextLine().split(" ");
            edgeObj = new Edge(map.get(directPath[0]),
                               map.get(directPath[1]),
                               Double.parseDouble(directPath[2]));
            digraph.addEdge(edgeObj);
        }
        int queries = Integer.parseInt(scan.nextLine());
        DijkstraSP spObj;
        for (int i = 0; i < queries; i++) {
            String[] check = scan.nextLine().split(" ");
            int source = map.get(check[0]);
            spObj = new DijkstraSP(digraph, source);
            System.out.println((int) spObj.distance(map.get(check[1])));
        }
    }
}
