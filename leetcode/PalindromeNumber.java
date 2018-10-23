public class PalindromeNumber {

	public static int reverseInteger(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x /= 10;
		}
		return result;
	}

	public static boolean isPalindrome(int x) {
		if (x >= 0 && x < 10) return true;
		if (x < 0) return false;
		int reverse = reverseInteger(x);
		System.out.println("reverse = " + reverse);
		System.out.println("x = " + x);
		return reverse == x;
	}

	public static void main(String[] args) {
		int x = 123;
		System.out.println(isPalindrome(x));
	}
}