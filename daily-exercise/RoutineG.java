import java.util.Arrays;
public class RoutineG {
	public RoutineG() {}

	///////////////////////////////////////////
	////////          Sorting          ////////
	///////////////////////////////////////////
	// Counting Sort.
	public void countingSort(int[] arr) {
		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();
		int range = max - min + 1;
		int[] count = new int[range];
		int[] output = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1]; 
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	///////////////////////////////////////////
	////////   Dynaminc Programming    ////////
	///////////////////////////////////////////

	/**
	 *
	 * 6765
	 */
	public int fibRecursive(int n) {
		if (n <= 1) return n;
		return fibRecursive(n - 1) + fibRecursive(n - 2);
	}

	/**
	 * 6765
	 */
	public int fibTopDown(int n) {
		return fibTopDown(n, new int[n + 1]);
	}

	private int fibTopDown(int n, int[] memo) {
		if (n <= 1) return n;
		if (memo[n] == 0) {
			memo[n] = fibTopDown(n - 1, memo) + fibTopDown(n - 2, memo);
		}
		return memo[n];
	}


	public int fibBottomUp(int n) {
		if (n <= 1) return n;
		int[] memo = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}

	public int fibOptimal(int n) {
		if (n <= 2) return n;
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public int quickSelect(int[] arr, int low, int high, int k) {
		return -1;
	}

	public int partition(int[] arr, int low, int high) {
		return i;
	}
	 
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}