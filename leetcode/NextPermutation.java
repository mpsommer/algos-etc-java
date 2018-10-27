public class NextPermutation {
	public int findPermuteStartIndex(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				return i - 1;
			}
		}
		return nums.length;
	}

	public int findNextGreatest(int[] nums, int index) {
		for (int i = nums.length - 1; i > index; i--) {
			if (nums[i] > nums[index]) {
				return i;
			}
		}
		return nums.length;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = partition(arr, low, high);
			quickSort(arr, low, mid - 1);
			quickSort(arr, mid + 1, high);
		}
	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	public void nextPermutation(int[] nums) {
		int permuteIndex = findPermuteStartIndex(nums);
		if (permuteIndex == nums.length) {
			quickSort(nums, 0, nums.length - 1);
		} else {
			int nextGreatestIndex = findNextGreatest(nums, permuteIndex);
			swap(nums, permuteIndex, nextGreatestIndex);
			quickSort(nums, permuteIndex + 1, nums.length - 1);
		}
	}
}