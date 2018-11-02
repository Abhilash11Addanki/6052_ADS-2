/**
 * Class for breadth first directed paths.
 */
public class BreadthFirstDirectedPaths {
	/**
	 * infinity value of type int.
	 */
    private static final int infinity = Integer.MAX_VALUE;
    /**
     * marked[v] = is there an s->v path?
     */
    private boolean[] marked;
    /**
     * edgeTo[v] = last edge on shortest s->v path.
     */
    private int[] edgeTo;
    /**
     * distTo[v] = length of shortest s->v path.
     */
    private int[] distTo;
    /**
     * Computes the shortest path from {@code s} and
     * every other vertex in graph {@code G}.
     * @param g the digraph
     * @param s the source vertex
     */
    public BreadthFirstDirectedPaths(final Digraph g, final int s) {
        marked = new boolean[g.V()];
        distTo = new int[g.V()];
        edgeTo = new int[g.V()];
        for (int v = 0; v < g.V(); v++)
            distTo[v] = infinity;
        bfs(g, s);
    }
    /**
     * Computes the shortest path from any one of the
     * source vertices in {@code sources}
     * to every other vertex in graph {@code G}.
     * @param G the digraph
     * @param sources the source vertices
     * @throws IllegalArgumentException unless each vertex {@code v} in
     *         {@code sources} satisfies {@code 0 <= v < V}
     */
    public BreadthFirstDirectedPaths(final Digraph g,
    	final Iterable<Integer> sources) {
        marked = new boolean[g.V()];
        distTo = new int[g.V()];
        edgeTo = new int[g.V()];
        for (int v = 0; v < g.V(); v++)
            distTo[v] = infinity;
        validateVertices(sources);
        bfs(g, sources);
    }
    /**
     * bfs from single source.
     * @param      g     Digraph g
     * @param      s     int.
     */
    private void bfs(final Digraph g, final int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    /**
     * bfs from multiple roots.
     * @param      g        Digraph g.
     * @param      sources  The sources
     */
    private void bfs(final Digraph g, final Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    /**
     * Is there a directed path from the source
     * {@code s} (or sources) to vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a directed path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return marked[v];
    }
    /**
     * Returns the number of edges in a shortest path from the source {@code s}
     * (or sources) to vertex {@code v}?
     * @param v the vertex
     * @return the number of edges in a shortest path
     */
    public int distTo(final int v) {
        return distTo[v];
    }
    /**
     * Returns a shortest path from {@code s} (or sources) to {@code v}, or
     * {@code null} if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     */
    public Iterable<Integer> pathTo(final int v) {
        if (!hasPathTo(v)) {
        	return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(x);
        return path;
    }
    /**
     * throw an IllegalArgumentException unless {@code 0 <= v < V}.
     * @param      v     int.
     */
    private void validateVertex(final int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v
            	+ " is not between 0 and " + (V-1));
    }
    /**
     * throw an IllegalArgumentException unless {@code 0 <= v < V}.
     * @param      vertices  The vertices
     */
    private void validateVertices(final Iterable<Integer> vertices) {
        int V = marked.length;
        for (int v : vertices) {
            if (v < 0 || v >= V) {
                throw new IllegalArgumentException("vertex " + v
                	+ " is not between 0 and " + (V-1));
            }
        }
    }
}
