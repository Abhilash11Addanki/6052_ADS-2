import java.util.Scanner;
/**
 *the class is to maintain the.
 *list representation of matrix.
 */
class Graph {
    /**
     *the variable to store number.
     *of vertices.
     */
    private int vertices;
    /**
    *the variable to store number.
    *of edges.
    */
    private int edges;
    /**
     *the array to store bag of arrays.
     */
    private Bag<Integer>[] adj;
    /**
     *the variable to store all keys.
     */
    private String[] tokens;
    /**
     *an empty constructor.
     */
    Graph() {
    }
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.vertices = V;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     *the constructor is to initialize the input given.
     *for the graph.
     *
     * @param      scan  The scan
     */
    Graph(final Scanner scan) {
        vertices = Integer.parseInt(scan.nextLine());
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
        int edge = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edge; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }
    /**
     *returns the vertices of graph.
     *
     * @return vertices of graph
     */
    public int vertices() {
        return vertices;
    }
    /**
     *returns the edges of graph.
     *
     * @return edges of graph
     */
    public int edges() {
        return edges;
    }
    /**
     *the method is to add an edge between.
     *two vertices.
     * @param      vertexOne  The vertex one
     * @param      vertexTwo  The vertex two
     * the time complexity is O(E)
     * E denotes the number of edges we have in graph.
     * because we use has next method.
     */
    public void addEdge(final int vertexOne,
                        final int vertexTwo) {
        if (vertexOne == vertexTwo) {
            return;
        }
        if (!hasEdge(vertexOne, vertexTwo)) {
            edges++;
        }
        adj[vertexOne].add(vertexTwo);
        adj[vertexTwo].add(vertexOne);
    }
    /**
     *the method is to maintian a iteratable for.
     *bag
     *returns an interator.
     * @param      vertex  The vertex
     *
     * @return  iterator.
     */
    public Iterable<Integer> adj(final int vertex) {
        return adj[vertex];
    }
    /**
     *the method is check whether there is a.
     *connection between two given vertices.
     *the time complexity is O(E)
     *E is the number of edges in graph.
     * @param      vertexOne  The vertex one
     * @param      vertexTwo  The vertex two
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int vertexOne,
                           final int vertexTwo) {
        for (int each : adj(vertexOne))  {
            if (each == vertexTwo) {
                return true;
            }
        }
        return false;
    }
    /**
     *the method is to print the string format.
     *of graph.
     *the time complexity will be O(N^2)
     *@return string format.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(vertices + " vertices, " + edges + " edges" + "\n");
        if (edges > 0) {
            for (int i = 0; i < vertices; i++) {
                str.append(tokens[i] + ": ");
                for (int j : adj[i]) {
                    str.append(tokens[j] + " ");
                }
                str.append("\n");
            }
            return str.toString();
        } else {
            str.append("No edges");
            return str.toString();
        }
    }
}
