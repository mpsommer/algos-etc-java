import java.util.*;
public class CustomComparator {

	static class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
		@Override
		public int compare(List<T> list1, List<T> list2) {
			return list1.get(1).compareTo(list2.get(1));
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> departRoutes = new LinkedList<>();
		Random rn = new Random();
		// for (int i = 1; i < 6; i++) {
		// 	List<Integer> route = new LinkedList<>();
		// 	route.add(i);
		// 	route.add(rn.nextInt(10) + 1);
		// 	route.add(rn.nextInt(10) + 1);
		// 	departRoutes.add(route);

		// }
		List<Integer> routea = new LinkedList<>();
		routea.add(1);
		routea.add(8);
		departRoutes.add(routea);
		List<Integer> routeb = new LinkedList<>();
		routeb.add(2);
		routeb.add(4);
		departRoutes.add(routeb);
		System.out.println(departRoutes);
		Collections.sort(departRoutes, new ListComparator<>());
		System.out.println(departRoutes);
	}
}