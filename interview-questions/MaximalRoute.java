import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

/**
 * Input: List of departure routes that are some distance with a unique key.
 * e.g. {{1, 350}, {2, 4000}, {3, 600}}. List of return routes that are like the
 * departure routes. Int maximalDistance
 * 
 * Task: Find the departure and return routes that == maximalDistance. If none
 * exist, then return the departure and return routes that are closest.
 */
public class MaximalRoute {
	static class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
		@Override
		public int compare(List<T> list1, List<T> list2) {
			return list1.get(1).compareTo(list2.get(1));
		}
	}

	public static List<List<Integer>> findMaxRoutes(List<List<Integer>> departRoutes, List<List<Integer>> returnRoutes,
			int maximalDistance) {
		List<List<Integer>> maxRoutes = new LinkedList<>();
		Collections.sort(departRoutes, new ListComparator<>());
		Collections.sort(returnRoutes, new ListComparator<>());
		List<List<Integer>> closeToOp = new LinkedList<>();

		List<Integer> temp = new LinkedList<>();
		temp.add(Integer.MIN_VALUE);
		temp.add(Integer.MIN_VALUE);
		closeToOp.add(temp);
		closeToOp.add(temp);
		System.out.println();
		System.out.println(departRoutes);
		System.out.println(returnRoutes);
		System.out.println();

		int i = departRoutes.size() - 1;
		int j = 0;
		while (i >= 0) {
			int depDist = departRoutes.get(i).get(1);
			int retDist = returnRoutes.get(j).get(1);
			if (depDist + retDist > maximalDistance) {
				i--;
			} else if (depDist + retDist < maximalDistance) {
				if (closeToOp.get(0).get(1) + closeToOp.get(1).get(1) < depDist + retDist) {
					closeToOp = new LinkedList<>();
					closeToOp.add(departRoutes.get(i));
					closeToOp.add(returnRoutes.get(j));
				}
				j++;
				if (j == returnRoutes.size()) {
					i--;
					j = 0;
				}
			} else {
				List<Integer> coord = new LinkedList<>();
				coord.add(departRoutes.get(i).get(0));
				coord.add(returnRoutes.get(j).get(0));
				maxRoutes.add(coord);
				i--;
			}
		}
		if (maxRoutes.size() < 1) {
			temp = new LinkedList<>();
			temp.add(closeToOp.get(0).get(0));
			temp.add(closeToOp.get(1).get(0));
			maxRoutes.add(temp);
		}
		return maxRoutes;
	}

	public static void main(String[] args) {
		List<List<Integer>> departRoutes = new LinkedList<>();
		List<List<Integer>> returnRoutes = new LinkedList<>();
		int maximalDistance = 16;
		Random rn = new Random();
		for (int i = 1; i < 8; i++) {
			List<Integer> route = new LinkedList<>();
			route.add(i);
			route.add(rn.nextInt(10) + 1);
			departRoutes.add(route);
		}

		// List<Integer> route1 = new LinkedList<>();
		// route1.add(1);
		// route1.add(3);
		// departRoutes.add(route1);
		// List<Integer> route2 = new LinkedList<>();
		// route2.add(2);
		// route2.add(5);
		// departRoutes.add(route2);
		// List<Integer> route3 = new LinkedList<>();
		// route3.add(3);
		// route3.add(7);
		// departRoutes.add(route3);
		// List<Integer> route4 = new LinkedList<>();
		// route4.add(4);
		// route4.add(10);
		// departRoutes.add(route4);
		System.out.println(departRoutes);

		for (int i = 1; i < 8; i++) {
			List<Integer> route = new LinkedList<>();
			route.add(i);
			route.add(rn.nextInt(10) + 1);
			returnRoutes.add(route);
		}

		// List<Integer> route5 = new LinkedList<>();
		// route5.add(1);
		// route5.add(1);
		// returnRoutes.add(route5);
		// List<Integer> route6 = new LinkedList<>();
		// route6.add(2);
		// route6.add(3);
		// returnRoutes.add(route6);
		// List<Integer> route7 = new LinkedList<>();
		// route7.add(3);
		// route7.add(4);
		// returnRoutes.add(route7);
		// List<Integer> route8 = new LinkedList<>();
		// route8.add(4);
		// route8.add(5);
		// returnRoutes.add(route8);
		System.out.println(returnRoutes);
		List<List<Integer>> routes = findMaxRoutes(departRoutes, returnRoutes, maximalDistance);
		System.out.println(routes);
	}
}