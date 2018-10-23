public class LongestPalindromicSubstring {

	public static String bruteForceSolution(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		String sub = "";
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
					String temp = str.substring(i, j+1);
					sub = (sub.length() > temp.length())? sub: temp;
				}
			}
		}
		return sub;
	}

	public static String dynamicProgramming(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		int n = str.length();
		boolean[][] table = new boolean[n][n];
		int start = 0;
		int maxLength = 0;

		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}
		for (int i = 1; i < n; i++) {
			table[i][i-1] = true;
		}

		for (int k = 1; k < n; k++) {
			int innerLoopLength = n - k;
			int j = k;
			for (int i = 0; i < innerLoopLength; i++, j++) {
				if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}

		// System.out.println("maxLength: " + (maxLength+1));
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
		// System.out.println(bruteForceSolution(str1));
		// System.out.println(bruteForceSolution(str2));
		// System.out.println(bruteForceSolution(str3));
		// System.out.println(bruteForceSolution(str4));
		// System.out.println(bruteForceSolution(str5));
		// System.out.println(bruteForceSolution(str6));
		// System.out.println(bruteForceSolution(str7));
		System.out.println(dynamicProgramming(str1));
		System.out.println(dynamicProgramming(str2));
		System.out.println(dynamicProgramming(str3));
		System.out.println(dynamicProgramming(str4));
		System.out.println(dynamicProgramming(str5));
		System.out.println(dynamicProgramming(str6));
		System.out.println(dynamicProgramming(str7));
		System.out.println(dynamicProgramming(str8));
		System.out.println(dynamicProgramming(str9));
	}
}