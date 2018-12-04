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

	public RoutineC() {
	}

	class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
		@Override
		public int compare(List<T> list1, List<T> list2) {
			return list1.get(1).compareTo(list2.get(1));
		}
	}

	///////////////////////////////////////////
	//////// Greedy ////////
	///////////////////////////////////////////
	public List<List<Integer>> maxActivities(List<List<Integer>> activities) {
		List<List<Integer>> result = new LinkedList<>();
		return result;
	}

	///////////////////////////////////////////
	//////// Permutations ////////
	///////////////////////////////////////////
	public void heapPermutation(int[] a, int size) {
	}

	///////////////////////////////////////////
	//////// Dynamic Programming ////////
	///////////////////////////////////////////
	public int knapSack(int W, int wt[], int val[], int n) {
		int[][] table = new int[n + 1][W + 1];
		return table[n][W];
	}

	///////////////////////////////////////////
	//////// Search ///////////////////////////
	///////////////////////////////////////////
	public void rabinKarp(char[] text, char[] pattern) {
	}

	private long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int exponent, int prime) {
		long newHash = oldHash - str[oldIndex];
		return newHash;
	}

	private long createHash(char[] str, int strLen, int prime) {
		long hash = 0;
		return hash;
	}

	private boolean checkEqual(char str1[], int start1, int end1, char str2[], int start2, int end2) {
		return true;
	}

	///// Utilities /////
	void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}