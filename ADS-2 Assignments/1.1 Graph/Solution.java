import java.util.Scanner;
import java.util.Arrays;
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		Bag<String> b = new Bag();
		String[] v = sc.nextLine().split(",");
		for (int i = 0; i < vertices; i++) {
			b.add(v[i]);
		}
		for (String s : b) {
			System.out.println(s);
		}
	}
}
