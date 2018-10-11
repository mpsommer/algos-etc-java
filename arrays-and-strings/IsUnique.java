import java.util.*;

public class IsUnique {

public static boolean isUnique(String str) {
	Map<Character, Integer> map = new HashMap<>();

	for (int i = 0; i < str.length(); i++) {
		if (map.containsKey(str.charAt(i))) {
			return false;
		} else {
			map.put(str.charAt(i), 1);
		}
	}
	return true;
}
	public static void main(String[] args) {
		String str = "Hello World!";
		System.out.println(str);
		System.out.println(isUnique(str));
	}
}