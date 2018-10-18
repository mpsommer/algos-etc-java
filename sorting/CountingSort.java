import java.util.*;

public class CountingSort{

	public static int findMaxValue(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int elem: arr) {
			if (elem > max) {
				max = elem;
			}
		}
		return max;
	}

	public static int[] countingSort(int[] arr) {

		
		int[] countArr = new int[findMaxValue(arr) + 1];
		int[] sortedArr = new int[arr.length];

		// Puts the number of input elements equal to i into countArr[i]
		for (int i = 0; i < arr.length; i++) {
			countArr[arr[i]] = countArr[arr[i]] + 1;
		}

		// Determines for each i = 0, 1, ..., countArr.length how many input
		// elements are less than or equal to i by keeping a running sum
		// of the countArr
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] = countArr[i] + countArr[i -1];
		}

		// Places each input element into its correct sorted position in the
		// sortedArr.
		for (int i = arr.length - 1; i >= 0; i--) {
			int arrVal = arr[i];
			int sortedArrIndex = countArr[arrVal] - 1;
			sortedArr[sortedArrIndex] = arrVal;
			countArr[arrVal] = countArr[arrVal] - 1;
		}
		return sortedArr;
	}
	
	public static void printArr(int[] arr) {
		for (int elem: arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {2, 5, 3, 0, 2, 3, 0, 5};
		printArr(arr);
		arr = countingSort(arr);
		printArr(arr);
	}

}