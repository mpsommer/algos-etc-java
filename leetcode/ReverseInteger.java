
// #7
import java.util.*;

public class ReverseInteger {

	public static int reverseInteger(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			// Check for overflow
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x /= 10;
		}
		return result;
	}
	public static void main(String[] args) {
		int foo = 1234567;
		System.out.println(reverseInteger(foo));
	}
}