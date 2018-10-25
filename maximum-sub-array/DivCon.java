import java.util.*;

public class DivCon {

	public static int[] maxCrossingSubArr(List<Integer> list, int low, int mid, int high) {
		int[] result = new int[3];
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = mid; i > low; i--) {
			sum += list.get(i);
			if (sum > leftSum) {
				leftSum = sum;
				result[0] = i;
			}
		}
		sum = 0;
		for (int j = mid + 1; j < high; j++) {
			sum += list.get(j);
			if (sum > rightSum) {
				rightSum = sum;
				result[1] = j;
			}
		}
		result[2] = leftSum + rightSum;
		return result;
	}

	public static int[] maxSubArray(List<Integer> list, int low, int high) {
		int[] result = new int[3];
		int[] leftArr = new int[3];
		int[] rightArr = new int[3];
		int[] crossArr = new int[3];

		if (low == high) {
			result[0] = low;
			result[1] = high;
			result[2] = list.get(high);
		} else {
			int mid = low + (high - low ) / 2; 
			leftArr = maxSubArray(list, low, mid);
			rightArr = maxSubArray(list, mid + 1, high);
			crossArr = maxCrossingSubArr(list, low, mid, high);
	
			if (leftArr[2] >= rightArr[2] && leftArr[2] >= crossArr[2]) {
				result = leftArr;
			} else if (rightArr[2] >= leftArr[2] && rightArr[2] >= crossArr[2]) {
				result = rightArr;
			} else {
				result = crossArr;
			}
		}
		return result;
	}








	// public static int[] maxCrossingSubArr(List<Integer> list, int low, int mid, int high) {
	// 	int leftSum = Integer.MIN_VALUE;
	// 	int rightSum = Integer.MIN_VALUE;
	// 	int sum = 0;
	// 	int[] result = new int[3];

	// 	for (int i = mid; i > low; i--) {
	// 		sum += list.get(i);
	// 		if (sum > leftSum) {
	// 			leftSum = sum;
	// 			result[0] = i;
	// 		}
	// 	}

	// 	sum = 0;
	// 	for (int j = mid + 1; j < high; j++ ) {
	// 		sum += list.get(j);
	// 		if (sum > rightSum) {
	// 			rightSum = sum;
	// 			result[1] = j;
	// 		}
	// 	}
	// 	result[2] = leftSum + rightSum;
	// 	return result;
	// }

	// public static int[] maxSubArray(List<Integer> list, int low, int high) {
	// 	int[] result = new int[3];
	// 	int[] leftArr = new int[3];
	// 	int[] rightArr = new int[3];
	// 	int[] crossArr = new int[3];

	// 	if (high == low) {
	// 		result[0] = low;
	// 		result[1] = high;
	// 		result[2] = list.get(high);
	// 	} else {
	// 		int mid = low + (high - low) / 2;
	// 		leftArr = maxSubArray(list, low, mid); 
	// 		rightArr = maxSubArray(list, mid + 1, high);
	// 		crossArr = maxCrossingSubArr(list, low, mid, high);
	// 	}

	// 	if (leftArr[2] >= rightArr[2] && leftArr[2] >= crossArr[2]) {
	// 		return leftArr;
	// 	} else if (rightArr[2] >= leftArr[2] && rightArr[2] >= crossArr[2]) {
	// 		return rightArr;
	// 	} else {
	// 		return crossArr;
	// 	}
	// }

	public static void printArray(int[] arr) {
		for (int elem: arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(-2);
		list.add(1);
		list.add(-3);
		list.add(4);
		list.add(-1);
		list.add(2);
		list.add(1);
		list.add(-5);
		list.add(4);
		System.out.println(list);
		int[] res = maxSubArray(list, 0, list.size() - 1);
		// 3, 6, 6
		printArray(res);
	}
}