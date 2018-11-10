/**
 * Dijkstra algorithm uses time complexity of O(E log(V)).
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * unused constructor.
         */
    }
    /**
     * main function handles the input and returns the
     * output to the console.
     * for via path it takes N*N complexity to print.
     * rest all depends on the Dijistra's algorithm
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner scan = new Scanner(System.in);

        int cities = scan.nextInt();
        scan.nextLine();
        int roadLines = scan.nextInt();
        scan.nextLine();
        EdgeWeightedGraph graph = new EdgeWeightedGraph(cities);

        for (int i = 0; i < roadLines; i++) {
            String[] paths = scan.nextLine().split(" ");
            int cityA = Integer.parseInt(paths[0]);
            int cityB = Integer.parseInt(paths[1]);
            int distance = Integer.parseInt(paths[2]);

            graph.addEdge(new Edge(cityA, cityB, distance));

        }

        String caseToGo = scan.nextLine();

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
            String[] str = scan.nextLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);

            DijkstraSP dj = new DijkstraSP(graph, s);

            double dis = dj.distTo(d);
            double inf = Double.POSITIVE_INFINITY;
            if (dis == inf) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(dis);
            }
            break;

        case "ViaPaths":
            String[] str1 = scan.nextLine().split(" ");
            int src = Integer.parseInt(str1[0]);
            int via = Integer.parseInt(str1[1]);
            int des = Integer.parseInt(str1[2]);

            DijkstraSP dj0 = new DijkstraSP(graph, src);
            // System.out.println(dj.pathTo(via));
            if (dj0.hasPathTo(via)) {
                DijkstraSP dj1 = new DijkstraSP(graph, via);

                if (dj1.hasPathTo(des)) {
                    System.out.println(dj0.distTo(via) + dj1.distTo(des));
                    int temp = src;
                    System.out.print(temp);
                    int oth = 1;
                    for (Edge i : dj0.pathTo(via)) {
                        oth = temp;
                        System.out.print(" " + i.other(oth));
                        temp = i.other(oth);
                    }

                    while (oth != des) {
                        for (Edge j : dj1.pathTo(des)) {

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
