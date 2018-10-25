
public class GCD {

	// public static int gcd(int a, int b) {
	// 	if (b == 0) {return a;}
	// 	return gcd(b, a % b);
	// }

	public static int gcd(int a, int b) {
		if (b == 0) {return a;}
		return gcd(b, a % b);
	}
	public static void main(String[] args) {
		System.out.println("gcd of " + 98 + " and " + 56 + " = " + gcd(98, 56)); // 14
		System.out.println("gcd of " + 7896 + " and " + 357 + " = " + gcd(7896, 357)); // 21
	}
}
