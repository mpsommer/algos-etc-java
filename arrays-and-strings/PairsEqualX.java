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
	}
}