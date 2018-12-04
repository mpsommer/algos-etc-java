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
		/**
		 * Compares the second element of a list of length 2.
		 */
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
		// Sort activities on the activity end time.
		Collections.sort(activities, new ListComparator<>());
		// Add the first activity.
		result.add(activities.get(0));
		// Get finish time of first activity.
		int finishTime = activities.get(0).get(1);
		for (int i = 1; i < activities.size(); i++) {
			// Get start time of first activity.
			int activityStart = activities.get(i).get(0);
			if (activityStart >= finishTime) {
				result.add(activities.get(i));
				// update finish time.
				finishTime = activities.get(i).get(1);
			}
		}
		return result;
	}

	///////////////////////////////////////////
	////////        Permutations       ////////
	///////////////////////////////////////////
	public void heapsAlgo(int[] a, int size) {
		// if size becomes 1 then prints the obtained
		// permutation
		if (size == 1) {
			printArr(a);
		}

		for (int i = 0; i < size; i++) {
			heapsAlgo(a, size - 1);

			// if size is odd, swap first and last
			// element
			if (size % 2 == 1) {
				int temp = a[0];
				a[0] = a[size - 1];
				a[size - 1] = temp;
			}
			// If size is even, swap ith and last
			// element
			else {
				int temp = a[i];
				a[i] = a[size - 1];
				a[size - 1] = temp;
			}
		}
	}

	// public void dfsPermute(String str, int start, int end, StringBuffer sb, boolean[] marked, List<String> result) {
	// 	if (start == end) {
	// 		result.add(sb.toString());
	// 		return;
	// 	}
	// 	for (int i = 0; i < str.length(); i++) {
	// 		if (!marked[i]) {
	// 			sb.append(str.charAt(i));
	// 			marked[i] = true;
	// 			dfsPermute(str, start + 1, end, sb, marked, result);
	// 			sb.deleteCharAt(sb.length() - 1);
	// 			marked[i] = false;
	// 		}
	// 	}
	// }

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


	///////////////////////////////////////////
	////////          Search           ////////
	///////////////////////////////////////////
	// https://www.quora.com/What-is-a-rolling-hash-and-when-is-it-useful
	// https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java
	public void rabinKarp(char[] text, char[] pattern) {
		int tLen = text.length;
		int pLen = pattern.length;
		int prime = 101;
		long txtHash = createHash(text, pLen, prime);
		long patHash = createHash(pattern, pLen, prime);
		for (int i = 0; i < tLen - pLen + 1; i++) {
			if (txtHash == patHash && checkEqual(text, i, i + pLen, pattern, 0, pLen)) {
				System.out.println("Pattern found at index: " + i);
			}
			if (i < tLen - pLen) {
				txtHash = recalculateHash(text, i, i + pLen, txtHash, pLen - 1, prime);
			}
		}
	}

	private long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int exponent, int prime) {
		long newHash = oldHash - str[oldIndex];
		newHash /= prime;
		newHash += str[newIndex] * Math.pow(prime, exponent);
		return newHash;
	}

	private long createHash(char[] str, int strLen, int prime) {
		long hash = 0;
		for (int i = 0; i < strLen; i++) {
			hash += str[i] * Math.pow(prime, i);
		}
		return hash;
	}

	private boolean checkEqual(char str1[], int start1, int end1, char str2[], int start2, int end2) {
		if (end1 - start1 != end2 - start2) {
			return false;
		}
		while (start1 < end1 && start2 < end2) {
			if (str1[start1] != str2[start2]) {
				return false;
			}
			start1++;
			start2++;
		}
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