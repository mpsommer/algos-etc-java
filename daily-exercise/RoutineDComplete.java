import java.util.LinkedList;
import java.util.List;
public class RoutineDComplete {
	///////////////////////////////////////////
	//////// Greedy //////////////////////////
	///////////////////////////////////////////
	public void kruskal() {
	}

	///////////////////////////////////////////
	//////// Dynamic Programming /////////////
	///////////////////////////////////////////
	// longest increasing subsequence
	public int lis(int[] arr, int n) {
		int[] lis = new int[n];
		int i, j;
		int max = 0;
		for (i = 0; i < n; i++) {
			lis[i] = 1;
		}
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		for (i = 0; i < n; i++) {
			if (max < lis[i]) {
				max = lis[i];
			}
		}
		return max;
	}

	///////////////////////////////////////////
	//////// Search ///////////////////////////
	///////////////////////////////////////////
	// https://www.youtube.com/watch?v=GTJr8OvyEVQ
	// https://www.youtube.com/watch?v=KG44VoDtsAA
	// https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
	public void KMP(char[] text, char[] pattern) {
		int lps[] = computeTempArray(pattern);
		int i = 0;
		int j = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
				if (j == pattern.length) { 
					System.out.println("Found pattern at index " + (i - j)); 
					j = lps[j - 1]; 
				} 
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	private int[] computeTempArray(char[] pattern) {
		int[] lps = new int[pattern.length];
		int j = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[j]) {
				lps[i] = j + 1;
				j++;
				i++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	///////////////////////////////////////////
	//////// Matching /////////////////////////
	///////////////////////////////////////////
	public void stableMarriage() {

	}
}