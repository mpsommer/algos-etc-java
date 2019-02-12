public class DriverE {

	static void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		RoutineE rtE = new RoutineE();
		String[] words = {"flower", "flows", "flowht"};
		rtE.buildTrie(words);
		System.out.println("///// Trie Contains Word /////");
		System.out.println("trie contains foster? " + rtE.containsWord("foster"));
		System.out.println("trie contains flower? " + rtE.containsWord("flower"));
		System.out.println();

		System.out.println("///// Trie Contains Prefix /////");
		System.out.println("trie contains fo? " + rtE.containsPrefix("fo"));
		System.out.println("trie contains fl? " + rtE.containsPrefix("fl"));
		System.out.println();

		System.out.println("///// Longest Common Prefix /////");
		System.out.println("Longest common prefix " + rtE.longestCommontPrefix());
		String[] wordsA = {"integration", "integrate", "integs"};
		rtE.buildTrie(wordsA);
		System.out.println("Longest common prefix " + rtE.longestCommontPrefix());
		System.out.println();

		System.out.println("///// BFS AutoComplete /////");
		String[] countries = {"samoa", "senegal", "serbia", "seychelles", 
							  "singapore", "slovakia", "slovenia", "somalia", 
							  "spain", "sudan", "suriname", "swaziland", "sweden",
							  "switzerland", "syria"};
		rtE.buildTrie(countries);
		String prefix = "s";
		System.out.println(rtE.autoCompleteBFS(prefix));
		System.out.println();

		System.out.println("///// DFS AutoComplete /////");
		System.out.println(rtE.autoCompleteDFS(prefix));
		System.out.println();
	}
}