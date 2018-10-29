import java.util.*;
public class Graph {
	private final int vertices;
	private int edges;
	private Bag<Integer>[] adj;
	Graph(int v) {
		vertices = v;
		edges = 0;
		adj = (Bag<Integer>[]) new Bag[vertices];
		for (int i = 0; i < vertices; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	Graph(Scanner sc) {
		vertices = sc.nextInt();
		adj = (Bag<Integer>[]) new Bag[vertices];
		for (int i = 0; i < vertices; i++) {
			adj[i] = new Bag<Integer>();
		}
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(v, w);
		}
	}
	Graph(Graph g) {
		Graph(g.vertices());
		edges = g.edges();
		for (int i = 0; i < g.vertices(); i++) {
			Stack<Integer> reverse = new Stack<Integer>();
			for (int w : g.adj[vertices]) {
				reverse.push(w);
			}
			for (int w : reverse) {
				adj[vertices].add(w);
			}
		}
	}
	public int vertices() {
		return vertices;
	}
	public int edges() {
		return edges;
	}
	public void addEdge(int v, int w) {
		edges++;
		adj[v].add(w);
		adj[w].add(v);
	}
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}