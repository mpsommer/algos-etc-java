

public class ThreeElemProdMax {

	public static int getThreeMaxProd(int[] arr) {
		if (arr.length < 3) {return -1;}
		java.util.Arrays.sort(arr);
		return arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 98, 56, 34, 7, 1, 105};

		System.out.println(getThreeMaxProd(arr));
	}
}

