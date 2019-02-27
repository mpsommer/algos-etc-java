import java.util.Arrays;
public class RoutineGComplete {
	public RoutineComplete() {}

	///////////////////////////////////////////
	////////          Sorting          ////////
	///////////////////////////////////////////
	/**
	 * 
	 * @param arr
	 * -10 -5 -3 -2 -1 0 5 8 10 12 
	 * Time complexity: O(n + k) where n is the number of elements in the input
	 * array and k is the range of the inuput.
	 * Space coplexity: O(n + k).
	 */
	public void countingSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max -  min + 1;
		int[] count = new int[range];
		int[] output = new int[arr.length];

		// Store the counts of each character.
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}

		// Calculate the cumulative sum array.
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// Build the output array.
		// Operating in reveerse order makes it stable.
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
			memo[n] = fibTopDown(n -1, memo) + fibTopDown(n - 2, memo);
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
		if (n <= 1) return n;
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
}