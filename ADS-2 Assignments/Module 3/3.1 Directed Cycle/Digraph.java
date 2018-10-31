/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * number of vertices in this digraph.
     */
    private final int V;
    /**
     * number of edges in this digraph.
     */
    private int E;
    /**
     * adj[v] = adjacency list for vertex v.
     */
    private Bag<Integer>[] adj;
    /**
     * indegree[v] = indegree of vertex v.
     */
    private int[] indegree;
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     * @param  V the number of vertices
     */
    public Digraph(final int V) {
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }        
    /**
     * Returns the number of vertices in this digraph.
     * @return the number of vertices in this digraph
     */
    public int V() {
        return V;
    }
    /**
     * Returns the number of edges in this digraph.
     * @return the number of edges in this digraph
     */
    public int E() {
        return E;
    }
    /**
     * Adds the directed edge v→w to this digraph.
     * @param  v the tail vertex
     * @param  w the head vertex
     */
    public void addEdge(final int v, final int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }
    /**
     * Returns the vertices adjacent from
     * vertex {@code v} in this digraph.
     * @param  v the vertex
     * @return the vertices adjacent from vertex
     * {@code v} in this digraph, as an iterable
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * Returns the number of directed edges
     * incident to vertex {@code v}.
     * This is known as the <em>indegree</em>
     * of vertex {@code v}.
     * @param  v the vertex
     * @return the indegree of vertex {@code v}
     */
    public int indegree(final int v) {
        return indegree[v];
    }
}
