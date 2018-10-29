import java.util.Scanner;
/**
 *the class is to maintain the.
 *graph representation of matrix.
 */
class GraphMatrix {
    /**
     *the tokens array is to.
     *store all the keys.
     */
    private String[] tokens;
    /**
     *matrix to store the realtion.
     *between two vertices.
     */
    private int[][] matrix;
    /**
     *the variable to store number.
     *of vertices.
     */
    private int vertices;
    /**
     *the variable to store edges of graph.
     */
    private int edges;
    /**
     *the constructor to initialize the.
     *class variables.
     */
    GraphMatrix() {
        edges = 0;
    }
    /**
     *the override constructor to.
     *maintian the complete graph
     *design.
     * @param      scan  The scan
     */
    GraphMatrix(final Scanner scan) {
        vertices = Integer.parseInt(scan.nextLine());
        matrix = new int[vertices][vertices];
        int edge = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edge; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addE(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }
    /**
     *the method is to add an edge between.
     *two vertices.
     * @param      vertexOne  The vertex one
     * @param      vertexTwo  The vertex two
     * because we use has next method.
     */
    public void addE(final int vertexOne,
     final int vertexTwo) {
        if (vertexOne != vertexTwo) {
            if (!hasEdge(vertexOne, vertexTwo)) {
                matrix[vertexOne][vertexTwo] = 1;
                matrix[vertexTwo][vertexOne] = 1;
                edges++;
            }
        }
    }
    /**
     *the method is check whether there is a.
     *connection between two given vertices.
     *the time complexity is O(1)
     * @param      vertexOne  The vertex one
     * @param      vertexTwo  The vertex two
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int vertexOne,
        final int vertexTwo) {
        if (matrix[vertexOne][vertexTwo] == 1) {
            return true;
        }
        return false;
    }
    /**
     *the method is to print the string format.
     *of graph.
     *the time complexity will be O(N^2)
     *N is the vertices here.
     */
    public void print() {
        String str = "";
        str += vertices + " vertices, " + edges + " edges" + "\n";
        if (edges > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    str += matrix[i][j] + " ";
                }
                str += "\n";
            }
            System.out.println(str);
        } else {
            str += "No edges";
            System.out.println(str);
        }
    }
}
