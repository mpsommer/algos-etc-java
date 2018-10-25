import java.util.*;

public class BruteForce {

	public static int[] maxSubArray(List<Integer> list) {
		int[] result = new int[3];
		int max = 0;

		for (int i = 0; i < list.size(); i++) {
			int maxSoFar = 0;
			for (int j = i; j < list.size(); j++) {
				maxSoFar += list.get(j);
				if (max <= maxSoFar) {
					max = maxSoFar;
					result[0] = i;
					result[1] = j;
					result[2] = max; 
				}
			}
		}
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