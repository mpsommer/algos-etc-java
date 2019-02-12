import java.util.List;
import java.util.LinkedList;

public class RoutineEComplete {
	private Trie trie;

	public RoutineEComplete() {}

	public void buildTrie(String[] words) {
		trie = new Trie();
		for (String word: words) {
			trie.insert(word);
		}
	}

	/**
	 * 
	 * @param word
	 * @return
	 * trie contains foster? false
	 * trie contains flower? true
	 */
	public boolean containsWord(String word) {
		return trie.containsWord(word);
	}


	/**
	 * 
	 * @param prefix
	 * @return
	 * trie contains fo? false
	 * trie contains fl? true
	 */
	public boolean containsPrefix(String prefix) {
		return trie.containsPrefix(prefix);
	}

	/**
	 * 
	 * @return
	 * flow
	 * integ
	 */
	public String longestCommontPrefix() {
		return trie.longestCommonPrefix();
	}

	/**
	 * 
	 * @param prefix
	 * @return
	 * [samoa, spain, sudan, syria, serbia, sweden, senegal, somalia, slovakia,
	 *  slovenia, suriname, singapore, swaziland, seychelles, switzerland]
	 */
	public List<String> autoCompleteBFS(String prefix) {
		List<String> words = new LinkedList<>();
		words = trie.bfsAutoComplete(prefix);
		return words;
	}

	/**
	 * 
	 * @param prefix
	 * @return
	 * [samoa, senegal, serbia, seychelles, singapore, slovakia, slovenia,
	 *  somalia, spain, sudan, suriname, swaziland, sweden, switzerland, syria]
	 */
	public List<String> autoCompleteDFS(String prefix) {
		List<String> words = new LinkedList<>();
		words = trie.dfsAutoComplete(prefix);
		return words;
	}

}