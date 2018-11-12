import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LSD l = new LSD();
		int n = Integer.parseInt(sc.nextLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}
		for (int i = 0; i < arr.length; i++) {
			l.sort(arr, arr[i].length());
		}
		System.out.println(Arrays.toString(arr));
	}
}
