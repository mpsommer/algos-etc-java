public class FirstOccurenceOfMaxNum {

	public static int FirstOccurenceOfMaxNum(int[] arr, int maxValue) {
		int index = -1;
		int l = 0;
		int r = arr.length -1;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if (arr[m] == maxValue && (m - 1 >= 0 && arr[m - 1] != maxValue)) {
				index = m;
				break;
			} else if (arr[m] < maxValue) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		// int[] arr = {1, 2, 3, 4, 5, 5, 5, 5, 5, 6, 6, 6};
		int[] arr = {6, 6, 6};
		System.out.println(FirstOccurenceOfMaxNum(arr, arr[arr.length-1]));

	}
}


