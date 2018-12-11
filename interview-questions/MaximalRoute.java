import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

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

	// public static List<List<Integer>> findMaxRoutes(List<List<Integer>> departRoutes, List<List<Integer>> returnRoutes,
	// 		int maximalDistance) {
	// 	List<List<Integer>> maxRoutes = new LinkedList<>();
	// 	Collections.sort(departRoutes, new ListComparator());
	// 	Collections.sort(returnRoutes, new ListComparator());
	// 	System.out.println();
	// 	System.out.println(departRoutes);
	// 	System.out.println(returnRoutes);

	// 	int i = departRoutes.size() - 1;
	// 	int j = 0;
	// 	while (i >= 0 && j < returnRoutes.size()) {
	// 		int dist = departRoutes.get(i).get(1) + returnRoutes.get(j).get(1);
	// 		if (dist > maximalDistance) {
	// 			i--;
	// 		} else if (dist < maximalDistance) {
	// 			j++;
	// 		} else {
	// 			List<Integer> coord = new LinkedList<>();
	// 			coord.add(departRoutes.get(i).get(0));
	// 			coord.add(returnRoutes.get(j).get(0));
	// 			maxRoutes.add(coord);
	// 			int x = j + 1;
	// 			while (x < returnRoutes.size()
	// 					&& departRoutes.get(i).get(1) + returnRoutes.get(x).get(1) == maximalDistance) {
	// 				coord = new LinkedList<>();
	// 				coord.add(departRoutes.get(i).get(0));
	// 				coord.add(returnRoutes.get(x).get(0));
	// 				maxRoutes.add(coord);
	// 				x++;
	// 			}
	// 			i--;
	// 		}
	// 	}
	// 	return maxRoutes;
	// }

	public static List<List<Integer>> findMaxRoutes(List<List<Integer>> departRoutes, List<List<Integer>> returnRoutes,
	int maximalDistance) {
		List<List<Integer>> maxRoutes = new LinkedList<>();
		TreeMap<Integer, List<Integer>> returnMap = getTreeMap(returnRoutes);
		TreeMap<Integer, List<Integer>> departMap = getTreeMap(departRoutes);
		List<Integer> coord;
		int closestMax = Integer.MIN_VALUE;

		for (int dKey: departMap.keySet()) {
			int rKey = maximalDistance - dKey;
			if (returnMap.containsKey(rKey)) {
				for (int dVal: departMap.get(dKey)) {
					for (int rVal: returnMap.get(rKey)) {
						coord = new LinkedList<>();
						coord.add(dVal);
						coord.add(rVal);
						maxRoutes.add(coord);
					}
				}
			}
		}

		if (maxRoutes.size() > 0) return maxRoutes;
		
		List<Integer> returnKeys = new LinkedList<>();
		List<Integer> departKeys = new LinkedList<>();
		for (int dKey: departMap.keySet()) {
			for (int rKey: returnMap.keySet()) {
				int dist = dKey + rKey;
				if (dist < maximalDistance && dist > closestMax) {
					returnKeys = new LinkedList<>();
					departKeys = new LinkedList<>();
					returnKeys.add(rKey);
					departKeys.add(dKey);
					closestMax = dist;
				} else if (dist < maximalDistance && dist == closestMax){
					returnKeys = new LinkedList<>();
					departKeys = new LinkedList<>();
					returnKeys.add(rKey);
					departKeys.add(dKey);
				}
			}
		}

		for (int dKey: departKeys) {
			for (int rKey: returnKeys) {
				for (int dValue: departMap.get(dKey)) {
					for (int rValue: returnMap.get(rKey)) {
						coord = new LinkedList<>();
						coord.add(dValue);
						coord.add(rValue);
						maxRoutes.add(coord);
					}
				}
			}
		}
		return maxRoutes;
	}
	private static TreeMap<Integer, List<Integer>> getTreeMap(List<List<Integer>> routes) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		List<Integer> value;
		for (List<Integer> route: routes) {
			if (map.containsKey(route.get(1))) {
				int key = route.get(1);
				value = map.get(key);
				value.add(route.get(0));
				map.put(key, value);
			} else {
				value = new LinkedList<>();
				value.add(route.get(0));
				map.put(route.get(1), value);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		List<List<Integer>> departRoutes = new LinkedList<>();
		List<List<Integer>> returnRoutes = new LinkedList<>();
		int maximalDistance = 25;
		Random rn = new Random();
		for (int i = 1; i < 8; i++) {
			List<Integer> route = new LinkedList<>();
			route.add(i);
			route.add(rn.nextInt(10) + 1);
			departRoutes.add(route);
		}

		// List<Integer> route1 = new LinkedList<>();
		// route1.add(1);
		// route1.add(8);
		// departRoutes.add(route1);
		// List<Integer> route2 = new LinkedList<>();
		// route2.add(2);
		// route2.add(9);
		// departRoutes.add(route2);
		// List<Integer> route3 = new LinkedList<>();
		// route3.add(3);
		// route3.add(8);
		// departRoutes.add(route3);
		// List<Integer> route4 = new LinkedList<>();
		// route4.add(4);
		// route4.add(10);
		// departRoutes.add(route4);
		// List<Integer> route5 = new LinkedList<>();
		// route5.add(5);
		// route5.add(5);
		// departRoutes.add(route5);
		// List<Integer> route6 = new LinkedList<>();
		// route6.add(6);
		// route6.add(5);
		// departRoutes.add(route6);
		// List<Integer> route7 = new LinkedList<>();
		// route7.add(7);
		// route7.add(6);
		// departRoutes.add(route7);
		System.out.println(departRoutes);

		for (int i = 1; i < 8; i++) {
			List<Integer> route = new LinkedList<>();
			route.add(i);
			route.add(rn.nextInt(10) + 1);
			returnRoutes.add(route);
		}

		// List<Integer> route8 = new LinkedList<>();
		// route8.add(1);
		// route8.add(1);
		// returnRoutes.add(route8);
		// List<Integer> route9 = new LinkedList<>();
		// route9.add(2);
		// route9.add(4);
		// returnRoutes.add(route9);
		// List<Integer> route10 = new LinkedList<>();
		// route10.add(3);
		// route10.add(6);
		// returnRoutes.add(route10);
		// List<Integer> route11 = new LinkedList<>();
		// route11.add(4);
		// route11.add(8);
		// returnRoutes.add(route11);
		// List<Integer> route12 = new LinkedList<>();
		// route12.add(5);
		// route12.add(8);
		// returnRoutes.add(route12);
		// List<Integer> route13 = new LinkedList<>();
		// route13.add(6);
		// route13.add(5);
		// returnRoutes.add(route13);
		// List<Integer> route14 = new LinkedList<>();
		// route14.add(7);
		// route14.add(6);
		// returnRoutes.add(route14);
		System.out.println(returnRoutes);
		List<List<Integer>> routes = findMaxRoutes(departRoutes, returnRoutes, maximalDistance);
		System.out.println(routes);
	}
}