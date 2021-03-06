import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;

/*
https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
Permutations: 
 */
public class RoutineCComplete {

	public RoutineCComplete() {
	}

	///////////////////////////////////////////
	////////           Greedy          ////////
	///////////////////////////////////////////
	/**
	 * 
	 * @param activities
	 * @return
	 * runtime: O(nlogn)
	 * [1,2], [3,4], [5,7], [8,9]
	 */
	public List<List<Integer>> maxActivities(List<List<Integer>> activities) {
		List<List<Integer>> result = new LinkedList<>();
		// Sort activities on the activity end time.
		Collections.sort(activities, (a, b) -> a.get(1) - b.get(1));
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
	/**
	 * 
	 * @param a
	 * @param size
	 * runtime: O(n!)
	 * 1 2 3
	 * 2 1 3
	 * 3 1 2
	 * 1 3 2
	 * 2 3 1
	 * 3 2 1
	 */
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
	/**
	 * runtime: O(nW), n = number of items, W = weight capacity of the sack.
	 * 220
	 */
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

	public void printKnapSackItems(int W, int[] wt, int[] val, int n, int[][] table) {
		int i = n;
		int w = W;
		while (i > 0 && w > 0) {
			if (table[i][w] != table[i - 1][w]) {
				System.out.println("item: " + wt[i - 1]);
				w = w - wt[i - 1];
			}
			i--;
		}
	}


	///////////////////////////////////////////
	////////          Search           ////////
	///////////////////////////////////////////
	/**
	 * 
	 * @param s
	 * @param p
	 * @return
	 * Illustrates sliding window.
	 * O(n)
	 * Found anagrams at: [0, 6]
	 * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92059/O(n)-Sliding-Window-JAVA-Solution-Extremely-Detailed-Explanation
	 */
	public List<Integer> findAnagrams(String s, String p) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Check for bad input
		if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
			return result;
		}
		
		//Set up character hash
		int[] chars = new int[26];
		for (Character c : p.toCharArray()){
			chars[c-'a']++;
		}
		
		int start = 0, end = 0, len = p.length(), diff = len;
		char temp;
		// check if s substring 0 p.lenghth is anagram.
		for (end = 0; end < len; end++){
			temp = s.charAt(end);
			chars[temp-'a']--;
			if (chars[temp-'a'] >= 0){
				diff--;
			}
		}
		if (diff == 0){
			result.add(0);
		}
		
		// Move window and check for anagrams.
		while (end < s.length()){
			// handle removal of first char.
			temp = s.charAt(start);
			if (chars[temp-'a'] >= 0){
				diff++;
			}
			chars[temp-'a']++;
			start++;
			

			// Add next char and check for anagram.
			temp = s.charAt(end);
			chars[temp-'a']--;
			if (chars[temp-'a'] >= 0){
				diff--;
			}
			if (diff == 0){
				result.add(start);
			}
			
			end++;
			
		}
		
		return result;
	
	 }










	// https://www.quora.com/What-is-a-rolling-hash-and-when-is-it-useful
	// https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java
	/**
	 * 
	 * @param text
	 * @param pattern
	 * Time complexity: Average case: O(n + m), worst case O(nm). n = text.length m = pattern.length
	 * 0, 10, 16
	 * 0, 9, 12
	 */
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