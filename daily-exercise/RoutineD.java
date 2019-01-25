import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
public class RoutineD {

	public String longestCommontPrefix(String[] words, String prefix) {
		return "";
	}

	///////////////////////////////////////////
	//////// Dynamic Programming /////////////
	///////////////////////////////////////////
	// longest increasing subsequence
	public int lis(int[] arr, int n) {
		return -1;
	}

	///////////////////////////////////////////
	//////// Search ///////////////////////////
	///////////////////////////////////////////
	// https://www.youtube.com/watch?v=GTJr8OvyEVQ
	// https://www.youtube.com/watch?v=KG44VoDtsAA
	// https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
	public void KMP(char[] text, char[] pattern) {
	}

	private int[] computeTempArray(char[] pattern) {
		int[] lps = new int[pattern.length];
		return lps;
	}

	///////////////////////////////////////////
	//////// Matching /////////////////////////
	///////////////////////////////////////////
	public void stableMarriage(String[] men, String[] women, String[][] mPref, String[][] wPref) {

	}

	private boolean preferNewPartner(String[][] womenPref, String curPartner, String newPartner, int index) {
		return false;
	}

	private int getPersonIndex(String str, String[] persons) {
		return -1;
	}
}