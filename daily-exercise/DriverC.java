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
		// activity[0] = activity number.
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
		}
		System.out.println();

		/// String Perm /////
		System.out.println("/////     String Perm     /////");
		int a[] = { 1, 2, 3 };
		rtC.heapPermutation(a, a.length);


	}
}