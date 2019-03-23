public class DriverG {


	static void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		RoutineG rtG = new RoutineG();
		System.out.println("///// counting sort.");
		int[] arr = {10, 12, -5, -3, -1, 0, -2, 5, 8, -10, 10};
		rtG.countingSort(arr);
		printArr(arr);
		System.out.println();

		System.out.println("///// Overlapping SubProblems");
		int n = 20;
		System.out.println("fibRecursive for " + n + ": " + rtG.fibRecursive(n));
		System.out.println("fibTopDown for " + n + ": " + rtG.fibTopDown(n));
		System.out.println("fibBottomUp for " + n + ": " + rtG.fibBottomUp(n));
		System.out.println("fibOptimal for " + n + ": " + rtG.fibOptimal(n));
		System.out.println();
		System.out.println("///// QuickSelect");
		int[] quickArr = {10, 12, -5, -3, -1, 0, -2, 5, 8, -10, 10};
		// int[] quickArr = {1,2,3};
		int high = quickArr.length - 1;
		int low = 0;
		int target = 11;
		int kSmallest = rtG.quickSelect(quickArr, low, high, target);
		System.out.println("kSmallest at index: " + kSmallest);

	}
}