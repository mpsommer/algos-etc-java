import java.util.LinkedList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Iterator;

public class RemoveDups {

	public static void removeDups(LinkedList<Integer> list) {
		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			int key = list.get(i);
			if (hash.contains(key)) {
				list.remove(i);
				i--;
			} else {
				hash.add(key);
			}
		}
	}


	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(7);
		list.add(5);
		list.add(88);

		System.out.println(list);
		removeDups(list);
		System.out.println(list);
	}
}