import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;
import java.util.Comparator;

/*
https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
Permutations: 
 */
public class RoutineC {

	public RoutineC() {}

	class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
		@Override
		public int compare(List<T> list1, List<T> list2) {
			return list1.get(1).compareTo(list2.get(1));
		}
	}

	///////////////////////////////////////////
	////////           Greedy          ////////
	///////////////////////////////////////////
	public List<List<Integer>> maxActivities(List<List<Integer>> activities) {
		List<List<Integer>> result = new LinkedList<>();
		return result;
	}

	///////////////////////////////////////////
	////////        Permutations       ////////
	///////////////////////////////////////////
	public void heapPermutation(int[] a, int size) {
	}

	///////////////////////////////////////////
	////////    Dynamic Programming    ////////
	///////////////////////////////////////////
	public int knapSack(int W, int wt[], int val[], int n) {
		int[][] table = new int[n+1][W+1];
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					table[i][w] = 0;
				} else if(wt[i -1] <= w) {
					table[i][w] = Math.max(val[i-1] + table[i-1][w - wt[i-1]], table[i-1][w]);
				} else {
					table[i][w] = table[i-1][w];
				}
			}
		}
		return table[n][W];
	}

	///// Utilities /////
	void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}