import java.util.*;

public class MergeSort {

	public static void mergeSort(List<Integer> list, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2; 
			mergeSort(list, low, mid);
			mergeSort(list, mid + 1, high);
			merge(list, low, mid, high);
		}
	}

	public static void merge(List<Integer> list, int low, int mid, int high) {
		int i, j, k;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();

		for (i = 0; i < mid + 1 - low; i++) {
			left.add(list.get(low + i));
		}

		for (j = 0; j < high - mid; j++) {
			right.add(list.get(mid + 1 + j));
		}

		i = 0;
		j = 0;
		k = low;

		while (i < left.size() && j < right.size()) {
			if (left.get(i) <= right.get(j)) {
				list.set(k, left.get(i));
				i++;
			} else {
				list.set(k, right.get(j));
				j++;
			}
			k++;
		}

		while (i < left.size()) {
			list.set(k, left.get(i));
			i++;
			k++;
		}

		while (j < right.size()) {
			list.set(k, right.get(j));
			j++;
			k++;
		}
	}

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
		mergeSort(arrList, 0, arrList.size()-1);
		System.out.println(arrList);
	}
}