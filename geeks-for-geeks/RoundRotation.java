public class RoundRotation {

	public static boolean isRotation(String str1, String str2, int index) {
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(index)) {
				return false;
			} else {
				System.out.println("index: " + index);
				index = (index + 1) % str2.length();
			}
		}
		return true;
	}

	public static boolean roundRotation(String str1, String str2) {
		boolean result = false;
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) == str1.charAt(0)) {
				result = isRotation(str1, str2, i);
				if (result) {
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "cab";
		System.out.println(roundRotation(str1, str2));
		str1 = "hello";
		str2 = "lohel";
		System.out.println(roundRotation(str1, str2));
		str1 = "cat";
		str2 = "aaa";
		System.out.println(roundRotation(str1, str2));
		str1 = "aaa";
		str2 = "aaa";
		System.out.println(roundRotation(str1, str2));
	}
}

// a b c
// c a b

// hello
// lohel

// c a t
// a a a