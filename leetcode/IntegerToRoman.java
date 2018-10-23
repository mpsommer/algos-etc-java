
// # 12
import java.util.*;

public class IntegerToRoman {
	public static int findPlaceValue(int x) {
		int placeValue = 1;
		while (x > 10) {
			x /= 10;
			placeValue *= 10;
		}
		return placeValue;
	}

	public static String getSymbol(int num) {
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "");
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		map.put(40, "XL");
		map.put(90, "XC");
		map.put(400, "CD");
		map.put(900, "CM");
		return map.get(num);
	}

	public static String intToRoman(int num) {
		StringBuffer buf = new StringBuffer();
		while (num != 0) {
			int placeValue = findPlaceValue(num);
			int x = num / placeValue;

			if (x == 4 || x == 5 || x == 9) {
				buf.append(getSymbol(x * placeValue));
			} else if (x > 5) {
				buf.append(getSymbol((x / 5) * 5 * placeValue));
				for (int i = 0; i < x % 5; i++) {
					buf.append(getSymbol(placeValue));
				}
			} else { // x < 5
				for (int i = 0; i < x; i++) {
					buf.append(getSymbol(placeValue));
				}
			}
			num -= num / placeValue * placeValue;
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		int x = 3999;
		System.out.println(intToRoman(x));
	}
}