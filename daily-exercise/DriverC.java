import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class DriverC {

	public static void main(String[] args) {
		RoutineC rtC = new RoutineC();
		/////     Greedy     /////
		List<List<Integer>> activities = new LinkedList<>();
		List<Integer> activity;
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
		activity = Arrays.asList(1,2);
		activities.add(activity);

		List<List<Integer>> list = rtC.maxActivities(activities);
		for (List<Integer> l: list) {
			System.out.println(l);
		}
		System.out.println();

		// for (List<Integer> l: activities) {
		// 	System.out.println(l);
		// }

	}
}