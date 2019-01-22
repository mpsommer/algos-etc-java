import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class DriverC {

	public static void main(String[] args) {
		RoutineC rtC = new RoutineC();
		///// Greedy /////
		System.out.println("/////     Greedy     /////");
		List<List<Integer>> activities = new LinkedList<>();
		List<Integer> activity;
		// activity[0] = activity start time.
		// activity[1] = activity end time.
		activity = Arrays.asList(5, 9);
		activities.add(activity);
		activity = Arrays.asList(0, 6);
		activities.add(activity);
		activity = Arrays.asList(3, 4);
		activities.add(activity);
		activity = Arrays.asList(5, 7);
		activities.add(activity);
		activity = Arrays.asList(8, 9);
		activities.add(activity);
		activity = Arrays.asList(1, 2);
		activities.add(activity);

		List<List<Integer>> list = rtC.maxActivities(activities);
		for (List<Integer> l : list) {
			System.out.println(l);
		} // [1,2], [3,4], [5,7], [8,9]
		System.out.println();

		/// String Perm /////
		System.out.println("/////     String Perm     /////");
		int a[] = { 1, 2, 3 };
		/*
		1 2 3
		2 1 3
		3 1 2
		1 3 2
		2 3 1
		3 2 1
		 */
		rtC.heapsAlgo(a, a.length);

		///// Dynamic Programing  /////
		System.out.println("/////     Dynamic Programming     /////");
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 1, 2, 3 };
		int W = 5;
		int n = val.length;
		System.out.println(rtC.knapSack(W, wt, val, n));


		///// Search sliding window anagrams /////
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println("/////     Sliding window     /////");
		System.out.println("Found anagrams at: " + rtC.findAnagrams(s, p));
		///// Search - rabin-karp  /////
		System.out.println("/////     Rabin Karp     /////");
		String text = "TIME is a TIME iTIMEaaaa";
		String pattern = "TIME";
		rtC.rabinKarp(text.toCharArray(), pattern.toCharArray()); // 0, 10, 16
		text = "AABAACAADAABAABA";
		pattern = "AABA";
		rtC.rabinKarp(text.toCharArray(), pattern.toCharArray()); // 0, 9, 12

	}
}