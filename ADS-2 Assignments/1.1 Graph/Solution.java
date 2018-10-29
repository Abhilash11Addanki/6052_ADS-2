import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main to read the input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        switch (type) {
        case "List":
            Graph graphObj = new Graph(sc);
            System.out.println(graphObj);
            break;
        case "Matrix":
            GraphMatrix graphMat = new GraphMatrix(sc);
            graphMat.print();
            break;
        default:
            break;
        }
    }
}
