public class BinarySearch {

	static int recursiveBinarySearch(int[] arr, int low, int high, int target) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (target < arr[mid]) {
				return recursiveBinarySearch(arr, low, mid - 1, target);
			}
			return recursiveBinarySearch(arr, mid + 1, high, target);
		}
		return -1;
	}

	static int iterativeBinarySearch(int[] arr, int low, int high, int val) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == val) {
				return mid;
			} else if (val < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	static int findIndexOfLowestRecursive(int[] arr, int low, int high) {
		// This condition is needed to handle the case when array
		// is not rotated at all
		if (high < low)
			return arr[0];

		// If there is only one element left
		if (high == low)
			return arr[low];

		// Find mid
		int mid = low + (high - low) / 2; /* (low + high)/2; */

		// Check if element (mid+1) is minimum element. Consider
		// the cases like {3, 4, 5, 1, 2}
		if (mid < high && arr[mid + 1] < arr[mid])
			return arr[mid + 1];

		// Check if mid itself is minimum element
		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		// Decide whether we need to go to left half or right half
		if (arr[high] > arr[mid])
			return findIndexOfLowestRecursive(arr, low, mid - 1);
		return findIndexOfLowestRecursive(arr, mid + 1, high);
	}

	public static int findIndexOfLowest(int[] arr) {
		int index = 0;
		int low = 0;
		int high = arr.length - 1;
	
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid < high && arr[mid] > arr[mid + 1]) {
				return mid + 1;
			} else if (mid > low && arr[mid] < arr[mid - 1]) {
				return mid;
			} else if (arr[high] > arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}

	// 1 2 3 4
	// 2 3 4 1
	// 3 4 1 2
	// 4 1 2 3
	public static void main(String[] args) {
		// int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 0));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 1));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 2));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 3));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 4));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 5));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 6));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 7));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 8));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 9));
		// System.out.println(iterativeBinarySearch(arr, 0, arr.length-1, 10));

		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 0));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 1));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 2));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 3));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 4));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 5));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 6));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 7));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 8));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 9));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 10));

		// int lowestIndex = findIndexOfLowest(arr);
		// System.out.println("lowestIndex " + lowestIndex);
		// int left = recursiveBinarySearch(arr, 0, lowestIndex, 0);
		// int right = recursiveBinarySearch(arr, lowestIndex + 1, arr.length - 1, 0);
		// System.out.println("left: "  + left);
		// System.out.println("right: " + right);
		// int result = (left > right) ? left : right;
		// System.out.println("Result: " + result);
	}
}