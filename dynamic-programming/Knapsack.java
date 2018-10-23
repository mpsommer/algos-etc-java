public class Knapsack {

	public static int knapSack(int W, int wt[], int val[], int n) {
		int[][] table = new int[n+1][W+1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					table[i][w] = 0;
				} else if(wt[i -1] <= w) {
					table[i][w] = Math.max(val[i-1] + table[i-1][w - wt[i-1]], table[i-1][w]);
				} else {
					table[i][w] = table[i-1][w];
				}
				System.out.print(table[i][w] + " ");
			}
			System.out.println();
		}
		return table[n][W];
	}
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 1, 2, 3 };
		int W = 5;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}