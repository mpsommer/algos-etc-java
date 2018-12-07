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
		System.out.println("///// longest increasing subsequence /////");
		int[] arr = {3, 10, 2, 1, 20}; 
		System.out.println("Length of lis is " + rtD.lis(arr, arr.length));
		int[] arrA = {3, 2}; 
		System.out.println("Length of lis is " + rtD.lis(arrA, arrA.length));
		int[] arrB = {50, 3, 10, 7, 40, 80}; 
		System.out.println("Length of lis is " + rtD.lis(arrB, arrB.length));
		System.out.println();

		System.out.println("///// KMP /////"); 
		// String str = "abcxabcdabcdabcy";
		String str = "abcxabcdabcyabcdabcdabcy";
		String subString = "abcdabcy";
		rtD.KMP(str.toCharArray(), subString.toCharArray());
		System.out.println();


	}
}