import java.util.*;

public class QuickSort {

	public static void quickSort(List<Integer> list, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(list, low, high);
			quickSort(list, low, partitionIndex - 1);
			quickSort(list, partitionIndex + 1, high);
		}
	}

	public static int partition(List<Integer> list, int low, int high) {
		int pivot = list.get(high);
		int lessIndex = low - 1;

		for (int greaterIndex= low; greaterIndex < high; greaterIndex++) {
			if (list.get(greaterIndex) > pivot) {
				lessIndex++;
				Collections.swap(list, lessIndex, greaterIndex);
			}
		}
		Collections.swap(list, lessIndex + 1, high);
		return lessIndex + 1;
	}












	// public static void quickSort(List<Integer> list, int low, int high) {
	// 	if (low < high) {
	// 		int partitionIndex = partition(list, low, high);
	// 		quickSort(list, low, partitionIndex -1);
	// 		quickSort(list, partitionIndex + 1, high);
	// 	}
	// }

	// public static int partition(List<Integer> list, int low, int high) {
	// 	int pivot = list.get(high);
	// 	int smallIndex = low - 1;

	// 	for (int largeIndex = low; largeIndex < high; largeIndex++) {
	// 		if (list.get(largeIndex) <= pivot) {
	// 			smallIndex++;
	// 			Collections.swap(list, smallIndex, largeIndex);
	// 		}
	// 	}
	// 	Collections.swap(list, smallIndex + 1, high);
	// 	return smallIndex + 1;
	// }

	public static void main(String[] args) {
		List<Integer> arrList = new ArrayList<Integer>();
		arrList.add(3);
		arrList.add(6);
		arrList.add(12);
		arrList.add(9);
		arrList.add(34);
		arrList.add(23);
		arrList.add(1);
		arrList.add(78);
		System.out.println(arrList);
		quickSort(arrList, 0, arrList.size()-1);
		System.out.println(arrList);
		arrList = new ArrayList<Integer>();
		arrList.add(1);
		arrList.add(2);
		arrList.add(3);
		arrList.add(4);
		System.out.println(arrList);
		quickSort(arrList, 1, arrList.size()-1);
		System.out.println(arrList);
	}
}