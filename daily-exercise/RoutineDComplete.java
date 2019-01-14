import java.util.LinkedList;
import java.util.List;
public class RoutineDComplete {
	// https://leetcode.com/articles/implement-trie-prefix-tree/
	public String longestCommontPrefix(String[] words, String prefix) {
		Trie trie = new Trie();
		String result  = "";
		for (String word: words) {
			trie.insert(word);
		}
		for (int i = 0; i < prefix.length(); i++) {
			String pre = prefix.substring(i, prefix.length());
			if (trie.startsWith(pre)) {
				result = pre;
			}
		}
		return result;
	}

	///////////////////////////////////////////
	//////// Dynamic Programming /////////////
	///////////////////////////////////////////
	// longest increasing subsequence
	/**
	 * 
	 * @param arr
	 * @param n
	 * @return
	 * runtime: O(n^2)
	 * 3, 1, 4
	 */
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
	/**
	 * runtime: O(m + n)
	 * Found pattern at: 4
	 * Found pattern at: 16
	 * Found pattern at: 10
	 */
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
		int i = 1;
		while ( i < pattern.length) {
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
	// https://www.sanfoundry.com/java-program-gale-shapley-algorithm/
	public void stableMarriage(String[] men, String[] women, String[][] mPref, String[][] wPref) {
		int N = mPref.length;
		int engagedCount = 0;
		boolean[] menEngaged = new boolean[N];
		String[] womenPartner = new String[N];
		int free = 0;

		while (engagedCount < N) {
			for (free = 0; free < N; free++) {
				if (!menEngaged[free]) {
					break;
				}
			}

			for (int i = 0; i < N && !menEngaged[free]; i++) {
				int index = getPersonIndex(mPref[free][i], women);
				if (womenPartner[index] == null) {
					womenPartner[index] = men[free];
					menEngaged[free] = true;
					engagedCount++;
				} else {
					String currentPartner = womenPartner[index];
					if (preferNewPartner(wPref, currentPartner, men[free], index)) {
						womenPartner[index] = men[free];
						menEngaged[free] = true;
						menEngaged[getPersonIndex(currentPartner, men)] = false;
					}
				}
			}
		}
		System.out.println("Couples are : ");
		for (int i = 0; i < N; i++)
		{
			System.out.println(womenPartner[i] +" "+ women[i]);
		}
	}

	private boolean preferNewPartner(String[][] womenPref, String curPartner, String newPartner, int index) {
		for (int i = 0; i < womenPref.length; i++) {
			if (womenPref[index][i].equals(newPartner)) return true;
			if (womenPref[index][i].equals(curPartner)) return false;
		}
		return false;
	}

	private int getPersonIndex(String str, String[] persons) {
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
}