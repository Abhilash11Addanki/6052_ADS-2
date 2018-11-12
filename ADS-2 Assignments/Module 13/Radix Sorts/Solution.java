import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LSD l = new LSD();
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		l.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
