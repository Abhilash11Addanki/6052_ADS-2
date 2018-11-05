/**
 * Class for edge weighted graph.
 */
public class EdgeWeightedGraph {
    /**
     * no of vertices.
     */
    private final int v;
    /**
     * no of edges.
     */
    private int e;
    /**
     * adj array of type Bag.
     */
    private Bag<Edge>[] adj;
    /**
     * Initializes an empty edge-weighted graph with
     * {@code V} vertices and 0 edges.
     * @param  v1 the number of vertices
     */
    public EdgeWeightedGraph(final int v1) {
        this.v = v1;
        this.e = 0;
        adj = (Bag<Edge>[]) new Bag[v1];
        for (int i = 0; i < v1; i++) {
            adj[i] = new Bag<Edge>();
        }
    }
    /**
     * Initializes a new edge-weighted graph that
     * is a deep copy of {@code G}.
     * @param  gp the edge-weighted graph to copy
     */
    public EdgeWeightedGraph(final EdgeWeightedGraph gp) {
        this(gp.vertices());
        this.e = gp.edges();
        for (int v1 = 0; v1 < gp.vertices(); v1++) {
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e1 : gp.adj[v1]) {
                reverse.push(e1);
            }
            for (Edge e1 : reverse) {
                adj[v1].add(e1);
            }
        }
    }
    /**
     * Returns the number of vertices in this edge-weighted graph.
     * @return the number of vertices in this edge-weighted graph
     */
    public int vertices() {
        return v;
    }
    /**
     * Returns the number of edges in this edge-weighted graph.
     *
     * @return the number of edges in this edge-weighted graph
     */
    public int edges() {
        return e;
    }
    /**
     * Adds the undirected edge {@code e} to this edge-weighted graph.
     *
     * @param  e1 the edge
     */
    public void addEdge(final Edge e1) {
        int v1 = e1.either();
        int w = e1.other(v1);
        adj[v].add(e1);
        adj[w].add(e1);
        e++;
    }
    /**
     * Returns the edges incident on vertex {@code v}.
     * @param  v1 the vertex
     * @return the edges incident on vertex {@code v} as an Iterable
     */
    public Iterable<Edge> adj(final int v1) {
        return adj[v1];
    }
    /**
     * Returns the degree of vertex {@code v}.
     * @param  v1 the vertex
     * @return the degree of vertex {@code v}
     */
    public int degree(final int v1) {
        return adj[v1].size();
    }
    /**
     * Returns all edges in this edge-weighted graph.
     * To iterate over the edges in this edge-weighted graph,
     * use foreach notation:
     * {@code for (Edge e : G.edges())}.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> noedges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int i = 0; i < v; i++) {
            int selfLoops = 0;
            for (Edge e1 : adj(i)) {
                if (e1.other(i) > i) {
                    list.add(e1);
                } else if (e1.other(i) == i) {
                //(self loops will be consecutive)
                    if (selfLoops % 2 == 0) {
                        list.add(e1);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }
}
