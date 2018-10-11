import java.util.*;

public class RemoveDups {

	public static String removeDups(String str) {
		Map<Character, Integer> map = new HashMap<>();
		StringBuffer sBuffer = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
				sBuffer.append(str.charAt(i));
			}
		}
		return sBuffer.toString();
	}

	public static void main(String[] args) {
		String str = "Hello World!";
		System.out.println(str);
		str = removeDups(str);
		System.out.println(str);
	}
}