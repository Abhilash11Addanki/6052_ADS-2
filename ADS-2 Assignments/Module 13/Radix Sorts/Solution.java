import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
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
