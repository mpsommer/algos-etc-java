import java.util.*;

public class InsertionSort {

	public static List<Integer> insertionSort(List<Integer> list) {
		int i, j, key;
		for (i = 1; i < list.size(); i++) {
			key = list.get(i);
			j = i -1;
			while (j >= 0 && list.get(j) > key) {
				list.set(j+1, list.get(j));
				j = j -1;
			}
			list.set(j+1, key);
		}
		return list;
	}

	public static void printArray(List<Integer> list) {
		for(Integer elem: list) {
			System.out.print(elem + " ");
		}
		System.out.println();
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

		printArray(arrList);
		arrList = insertionSort(arrList);
		printArray(arrList);
	}
}