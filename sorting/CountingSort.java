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

		for (int i = 0; i < arr.length; i++) {
			int index = arr[i];
			countArr[index] = countArr[index] + 1;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] = countArr[i] + countArr[i -1];
		}
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