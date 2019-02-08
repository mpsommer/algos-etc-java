import java.util.List;
import java.util.LinkedList;

public class DriverD {

	static void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		RoutineD rtD = new RoutineD();
		System.out.println("///// longest common prefix (trie) /////");
		String[] words = {"flower", "flow", "flowht"};
		String[] countries = {"samoa", "senegal", "serbia", "seychelles", 
							  "singapore", "slovakia", "slovenia", "somalia", 
							  "spain", "sudan", "suriname", "swaziland", "sweden",
							  "switzerland", "syria"};
		String prefix = "flower";
		System.out.println(rtD.longestCommontPrefix(countries, prefix));
		String[] wordsA = {"integration", "integrate", "integ"};
		String prefixA = "int";
		System.out.println(rtD.longestCommontPrefix(wordsA, prefixA));
		System.out.println();
		System.out.println("///// longest increasing subsequence /////");
		int[] arr = {3, 10, 2, 1, 20}; 
		System.out.println("Length of lis is " + rtD.lis(arr, arr.length)); // 3
		int[] arrA = {3, 2}; 
		System.out.println("Length of lis is " + rtD.lis(arrA, arrA.length)); // 1
		int[] arrB = {50, 3, 10, 7, 40, 80}; 
		System.out.println("Length of lis is " + rtD.lis(arrB, arrB.length)); // 4
		System.out.println();

		System.out.println("///// KMP /////"); 
		// String str = "abcxabcdabcdabcy";
		String str = "abcxabcdabcyabcdabcdabcy";
		String subString = "abcdabcy";
		rtD.KMP(str.toCharArray(), subString.toCharArray()); // 4, 16
		System.out.println();
		String txt = "ABABDABACDABABCABAB"; 
		String pat = "ABABCABAB"; 
		rtD.KMP(txt.toCharArray(), pat.toCharArray()); // 10
		System.out.println();

		System.out.println("///// SMP /////");
		String[] m = {"M1", "M2", "M3", "M4", "M5"};
		String[] w = {"W1", "W2", "W3", "W4", "W5"};
		String[][] mp = {
			{"W5", "W2", "W3", "W4", "W1"},
			{"W2", "W5", "W1", "W3", "W4"},
			{"W4", "W3", "W2", "W1", "W5"},
			{"W1", "W2", "W3", "W4", "W5"},
			{"W5", "W2", "W3", "W4", "W1"}
		};
		String[][] wp = {
			{"M5", "M3", "M4", "M1", "M2"},
			{"M1", "M2", "M3", "M5", "M4"},
			{"M4", "M5", "M3", "M2", "M1"},
			{"M5", "M2", "M1", "M4", "M3"},
			{"M2", "M1", "M4", "M3", "M5"}
		};
		String[] men = {"Albert", "Bradley", "Charles"};
		String[] women = {"Diane", "Emily", "Fergie"};
		String[][] mPref = {
			{"Diane","Emily","Fergie"},
			{"Emily","Diane","Fergie"},
			{"Diane","Emily","Fergie"}
		};
		String[][] wPref = {
			{"Bradley","Albert","Charles"},
			{"Albert","Bradley","Charles"},
			{"Albert","Bradley","Charles"},
		};

		rtD.stableMarriage(m, w, mp, wp);
		// Couples are :
		// M4 W1
		// M2 W2
		// M5 W3
		// M3 W4
		// M1 W5
		rtD.stableMarriage(men, women, mPref, wPref);
		// Couples are :
		// Albert Diane
		// Bradley Emily
		// Charles Fergie
	}
}