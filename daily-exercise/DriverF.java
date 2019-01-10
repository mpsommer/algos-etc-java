import java.util.List;
import java.util.LinkedList;

public class DriverF {
	public static void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		RoutineF rtF = new RoutineF();

		// Minimum spanning tree.
		int graph[][] = new int[][] {
			{0, 2, 0, 6, 0},
			{2, 0, 3, 8, 5},
			{0, 3, 0, 0, 7},
			{6, 8, 0, 0, 9},
			{0, 5, 7, 9, 0}
		};

		// 0 - 1: 2
		// 1 - 2: 3
		// 0 - 3: 6
		// 1 - 4: 5
		rtF.prims(graph);

		// Sorting
		int[] arr = {12, 11, 13, 5, 6, 7};
		rtF.heapSort(arr);
		printArr(arr);
	}
}