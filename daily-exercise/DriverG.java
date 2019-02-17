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
	}
}