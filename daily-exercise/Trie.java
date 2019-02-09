import java.lang.StringBuilder;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Trie {

	private TrieNode root;

	public Trie() {
	}

	// Inserts a word into a Trie.
	public void insert(String word) {
	}

	// Search a prefix or a whole key in trie and
	// return the node where search ends.
	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		return node;
	}

	// Returns true if the word is in the Trie
	public boolean containsWord(String word) {
		return false;
	}

	public boolean containsPrefix(String prefix) {
		return false;
	}

	public String longestCommonPrefix() {
		return "";
	}

	public List<String> bfsAutoComplete(String prefix) {
		List<String> words = new LinkedList<>();
		return words;
	}

	public List<String> dfsAutoComplete(String prefix) {
		List<String> words = new LinkedList<>();
		return words;
	}

	public void dfs(TrieNode node, List<String> words, StringBuilder sb) {
	}

	private int getNumLinks(TrieNode node) {
		int count = 0;
		return count;
	}

	class TrieNode {
	}
}