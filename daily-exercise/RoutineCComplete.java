import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;
import java.util.Comparator;
import java.util.ArrayList;

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
	 * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92059/O(n)-Sliding-Window-JAVA-Solution-Extremely-Detailed-Explanation
	 */
	public List<Integer> findAnagrams(String s, String p) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Check for bad input
		if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
			return new ArrayList<Integer>();
		}
		
		//Set up character hash
		//Keep track of how many times each character appears
		int[] chars = new int[26];
		for (Character c : p.toCharArray()){
			//Increment to setup hash of all characters currently in the window
			//Later on, these get DECREMENTED when a character is found
			//A positive count later on means that the character is still "needed" in the anagram
			//A negative count means that either the character was found more times than necessary
			//Or that it isn't needed at all
			chars[c-'a']++;
		}
		
		//Start = start poniter, end = end pointer,
		//len = length of anagram to find
		//diff = length of currently found anagram. If it equals
		//the length of anagram to find, it must have been found
		int start = 0, end = 0, len = p.length(), diff = len;
		
		char temp;
		//Before we begin this, the "window" has a length of 0, start and
		//end pointers both at 0
		for (end = 0; end < len; end++){
			//Process current char
			temp = s.charAt(end);
			
			//As discussed earlier, decrement it
			chars[temp-'a']--;
			
			//If it's still >= 0, the anagram still "needed" it so we count it towards the anagram by
			//decrementing diff
			if (chars[temp-'a'] >= 0){
				diff--;
			}
		}
		
		//This would mean that s began with an anagram of p
		if (diff == 0){
			result.add(0);
		}
		
		//At this point, start remains at 0, end has moved so that the window is the length of the anagram
		//from this point on we are going to be moving start AND end on each iteration, to shift the window
		//along the string
		while (end < s.length()){
			
			//Temp represents the current first character of the window. The character that is
			//going to be "left behind" as the window moves. 
			temp = s.charAt(start);
			
			//If it's not negative, this means that the character WAS part of the anagram. That means we
			//are one step "farther away" from completing an anagram. So we must increment diff.
			if (chars[temp-'a'] >= 0){
				diff++;
			}
			
			//Increment the hash value for this character, because it is no longer contained in the window
			chars[temp-'a']++;
			
			//Increment start to start shifting the window over by 1
			start++;
			
			//Temp represents the last character of the window, the "new" character from the window shift.
			//This character "replaces" the one we removed before so the window stays the same length (p.length())
			temp = s.charAt(end);
			
			//Decrement hash value for this character, because it is now a part of the window
			chars[temp-'a']--;
			
			//Again, if it's not negative it is part of the anagram. So decrement diff
			if (chars[temp-'a'] >= 0){
				diff--;
			}
			
			//If diff has reached zero, that means for the last p.length() iterations, diff was decremented and
			//NOT decremented, which means every one of those characters was in the anagram, so it must be an anagram
			
			//Note: If many windows in a row find anagrams, then each iteration will have diff incremented then decremented again
			if (diff == 0){
				result.add(start);
			}
			
			//Increment for next iteration
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