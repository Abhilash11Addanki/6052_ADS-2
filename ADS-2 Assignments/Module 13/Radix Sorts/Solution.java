import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method that drives the program.
     * @param      args  The arguments
     * Time complexity for this method is O(W*N*log N).
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Quick3string q = new Quick3string();
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        q.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
