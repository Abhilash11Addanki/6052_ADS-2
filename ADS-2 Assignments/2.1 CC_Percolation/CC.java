/**
 * Class for cc.
 */
public class CC {
	/**
	 * marked[v] = has vertex v been marked?.
	 */
    private boolean[] marked;
    /**
     * id[v] = id of connected component containing v.
     */
    private int[] id;
    /**
     * size[id] = number of vertices in given component.
     */
    private int[] size;
    /**
     * number of connected components.
     */
    private int count;

    /**
     * Computes the connected components of the undirected graph {@code G}.
     * @param G the undirected graph
     */
    public CC(final Graph G) {
        marked = new boolean[G.ve()];
        id = new int[G.ve()];
        size = new int[G.ve()];
        for (int v = 0; v < G.ve(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }
    /**
     * depth-first search for a Graph.
     * @param      G     G of type Graph.
     * @param      v     v of type int.
     */
    private void dfs(final Graph G, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * Returns the component id of the connected component containing vertex {@code v}.
     * @param  v the vertex
     * @return the component id of the connected component containing vertex {@code v}
     */
    public int id(int v) {
        return id[v];
    }
    /**
     * Returns true if vertices {@code v} and {@code w} are in the same
     * connected component.
     * @param  v one vertex
     * @param  w the other vertex
     * @return {@code true} if vertices {@code v} and {@code w} are in the same
     *         connected component; {@code false} otherwise
     */
    public boolean connected(final int v, final int w) {
        return id(v) == id(w);
    }
}
