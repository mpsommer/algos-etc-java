public class LongestPalindromicSubstring {

	// TODO: Fix me.
	public static String bruteForceSolution(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		int start = 0;
		int maxLength = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				int x = i;
				int y = j;
				boolean isPal = true;
				while (x <= y) {
					if (str.charAt(x) != str.charAt(y)) {
						isPal = false;
						break;
					}
					x++;
					y--;
				}
				if (isPal && i <= j) {
					if (y - x > maxLength) {
						start = i;
						maxLength = j;
					}
				}
			}
		}
		return str.substring(start, start + maxLength +1);
	}

	public static String dynamicProgramming(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}

		int len = str.length();
		boolean[][] table = new boolean[len][len];
		int start = 0;
		int maxLength = 0;

		for (int i = 0; i < len; i++) {
			table[i][i] = true;
		}

		for (int i = 1; i < len; i++) {
			table[i][i-1] = true;
		}

		for (int k = 1; k < len; k++) {
			int innerLoopLength = len - k;
			int col = k;
			for (int row = 0; row < innerLoopLength; row++, col++) {
				if (table[row+1][col-1] && str.charAt(row) == str.charAt(col)) {
					table[row][col] = true; 
					if (k > maxLength) {
						start = row;
						maxLength = k;
					}
				}
			}
		}
		return str.substring(start, start + maxLength+1);

	}

	public static void printTable(boolean[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				System.out.print(table[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String str1 = "cbbd";
		String str2 = "racecar";
		String str3 = "a";
		String str4 = "";
		String str5 = "car";
		String str6 = "abbababab";
		String str7 = "asdfaaafdsab";
		String str8 = "ppp";
		String str9 = "papcdad";
		System.out.println("##### Brute Force #####");
		System.out.println(bruteForceSolution(str1));
		System.out.println(bruteForceSolution(str2));
		System.out.println(bruteForceSolution(str3));
		System.out.println(bruteForceSolution(str4));
		System.out.println(bruteForceSolution(str5));
		System.out.println(bruteForceSolution(str6));
		System.out.println(bruteForceSolution(str7));
		System.out.println("##### Dynamic Programming #####");
		System.out.println(dynamicProgramming(str1)); // bb
		System.out.println(dynamicProgramming(str2)); // racecar
		System.out.println(dynamicProgramming(str3)); // a
		System.out.println(dynamicProgramming(str4)); // 
		System.out.println(dynamicProgramming(str5)); // c
		System.out.println(dynamicProgramming(str6)); // bababab
		System.out.println(dynamicProgramming(str7)); // asdfaaafdsa
		System.out.println(dynamicProgramming(str8)); // ppp
		System.out.println(dynamicProgramming(str9)); // pap
	}
}