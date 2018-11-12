import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;
import java.util.Comparator;
/*
https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 */
public class RoutineC {

	public RoutineC() {}

	class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
		@Override
		public int compare(List<T> list1, List<T> list2) {
			return list1.get(1).compareTo(list2.get(1));
		}
	}

	///////////////////////////////////////////
	////////          Greedy           ////////
	///////////////////////////////////////////
	public List<List<Integer>> maxActivities(List<List<Integer>> activities) {
		List<List<Integer>> result = new LinkedList<>();
		Collections.sort(activities, new ListComparator<>());
		// Add the first activity.
		result.add(activities.get(0));
		int finishTime = activities.get(0).get(1);
		for (int i = 1; i < activities.size(); i++) {
			int activityStart = activities.get(i).get(0);
			if ( activityStart >= finishTime) {
				result.add(activities.get(i));
				finishTime = activities.get(i).get(1); // activityFinish
			}
		}
		return result;
	}
 }