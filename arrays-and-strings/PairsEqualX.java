import java.util.HashMap;
import java.util.Map;
public class PairsEqualX {
	public static void printPairsEqualToX(int[] arr, int X) {
		java.util.Arrays.sort(arr);
		int end = arr.length -1;
		int start = 0;
			while(start != end) {
			int product = arr[start] * arr[end];
			if (product == X) {
				System.out.println(arr[start] + " " + arr[end]);
				start++;
			} else if (product > X) {
				end--;
			} else {
				start++;
			}
		}
	}

	// public static void pairsEqual2(int[] arr, int X) {
	// 	Map<Integer, Integer> map = new HashMap<>();
	// 	for (int elem: arr) {
	// 		if(!map.containsKey(elem)) {
	// 			map.put(elem, 1);
	// 		}
	// 	}
	// 	for (int elem: arr) {
	// 		if (map.containsKey(X % elem)) {
	// 			System.out.println(elem + " " + X/elem);
	// 		}
	// 	}
	// }

	public void printArray(int[] arr) {
		for(int elem: arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {12, 5, 2, 2, 8, 3, 6, 4, 1, 11};
		int X = 12;
		printPairsEqualToX(arr, X);
		// System.out.println("#######");
		// pairsEqual2(arr, X);
	}
}