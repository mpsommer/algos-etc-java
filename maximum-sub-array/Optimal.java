import java.util.*;

public class Optimal {

	public static int[] maxSubArray(List<Integer> list) {
		int maxSum = 0;
		int maxSoFar = 0;
		int[] result = new int[3];
		boolean newBeginning = false;

		for (int i = 0; i < list.size(); i++) {
			maxSoFar += list.get(i);

			if (maxSoFar < 0) {
				maxSoFar = 0;
				newBeginning = true;
			}

			if (maxSoFar > maxSum) {
				maxSum = maxSoFar;
				if(newBeginning) {
					result[0] = i;
					newBeginning = false;
				}
				result[1] = i;
			}
		}
		result[2] = maxSum;
		return result;
	}

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
		int[] res = maxSubArray(list);
		// 3, 6, 6
		printArray(res);
	}
}