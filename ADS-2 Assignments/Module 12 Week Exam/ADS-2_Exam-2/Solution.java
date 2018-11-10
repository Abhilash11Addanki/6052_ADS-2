import java.util.Scanner;
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
     * This method drives the program.
     * @param      args  The arguments
     * Time complexity for this method is O(E log V) Since
     * it uses Dijkstra's Algorithm to find shortest path.
     * where E is no of edges and V is no of vertices.
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner sc = new Scanner(System.in);

        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        // EdgeWeightedGraph to construct the graph.
        EdgeWeightedGraph graph = new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] input = sc.nextLine().split(" ");
            int verA = Integer.parseInt(input[0]);
            int verB = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);

            graph.addEdge(new Edge(verA, verB, distance));

        }

        String caseToGo = sc.nextLine();

        switch (caseToGo) {
        case "Graph":
            //Print the Graph Object.
            System.out.println(graph);
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] str = sc.nextLine().split(" ");
            int source = Integer.parseInt(str[0]);
            int dest = Integer.parseInt(str[1]);
            // Dijkstra's Algorithm.
            DijkstraSP dsp = new DijkstraSP(graph, source);
            double dis = dsp.distTo(dest);
            double inf = Double.POSITIVE_INFINITY;
            if (dis == inf) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(dis);
            }
            break;

        case "ViaPaths":
            String[] str1 = sc.nextLine().split(" ");
            int src = Integer.parseInt(str1[0]);
            int via = Integer.parseInt(str1[1]);
            int des = Integer.parseInt(str1[2]);

            DijkstraSP dsp1 = new DijkstraSP(graph, src);
            // System.out.println(dj.pathTo(via));
            if (dsp1.hasPathTo(via)) {
                DijkstraSP dsp2 = new DijkstraSP(graph, via);

                if (dsp2.hasPathTo(des)) {
                    System.out.println(dsp1.distTo(via) +
                        dsp2.distTo(des));
                    int temp = src;
                    System.out.print(temp);
                    int oth = 1;
                    for (Edge i : dsp1.pathTo(via)) {
                        oth = temp;
                        System.out.print(" " + i.other(oth));
                        temp = i.other(oth);
                    }
                    while (oth != des) {
                        for (Edge j : dsp2.pathTo(des)) {
                            try {
                                oth = temp;
                                System.out.print(" " + j.other(oth));
                                temp = j.other(oth);
                            } catch (Exception e) {
                                continue;
                            }

                        }
                    }
                } else {
                    System.out.println("No Path Found.");
                }

            } else {
                System.out.println("No Path Found.");
            }
            break;

        default:
            break;
        }

    }
}
