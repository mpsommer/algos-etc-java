public class Fibonacci {
	public static int fibonacci(int n) {
		return fibonacci(n, new int[n + 1]);
	}

	public static int fibonacci(int i, int[] memo) {
		if (i == 0 || i == 1) { return i;}

		if (memo[i] == 0) {
			memo[i] = fibonacci(i - 1, memo)+ fibonacci(i - 2, memo);
		}

		return memo[i];
	}


	public static void main(String[] args) {
		System.out.println(fibonacci(23));
	}
}