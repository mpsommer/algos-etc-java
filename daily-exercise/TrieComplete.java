import java.lang.StringBuilder;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TrieComplete {

	private TrieNode root;

	public TrieComplete() {
		root = new TrieNode();
	}

	// Inserts a word into a Trie.
	public void insert(String word) {
		TrieNode node = root;
		for (char c: word.toCharArray()) {
			if (!node.containsKey(c)) {
				node.put(c);
			}
			node = node.get(c);
		}
		node.setEnd();
	}

	// Search a prefix or a whole key in trie and
	// return the node where search ends.
	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (char c: word.toCharArray()) {
			if (node.containsKey(c)) {
				node = node.get(c);
			} else {
				return null;
			}
		}
		return node;
	}

	// Returns true if the word is in the Trie
	public boolean containsWord(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	public boolean containsPrefix(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

	public String longestCommonPrefix() {
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;
		int count = 0;
		char charToAdd = ' ';
		do {
			count = 0;
			for (int i = 0; i < node.R; i++) {
				char c = (char)('a' + i);
				if (node.get(c) != null) {
					charToAdd = c;
					count++;
				}
			}
			if (count == 1) {
				sb.append(charToAdd);
				node = node.get(charToAdd);
			} else {
				return sb.toString();
			}
		} while (count == 1 && !node.isEnd());
		return sb.toString();
	}

	public List<String> bfsAutoComplete(String prefix) {
		List<String> words = new LinkedList<>();
		if (prefix == null || prefix.length() == 0) return words;
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;
		char c;
		
		// Build prefix string and position node correctly.
		for (int i = 0; node != null && i < prefix.length(); i++) {
			c = prefix.charAt(i);
			if (!node.containsKey(c)) {
				// Prefix not found in trie.
				return words;
			} 
			sb.append(c);
			node = node.get(c);
		}

		// bfs for words stemming from prefix.
		Queue<TrieNode> nodeQueue = new LinkedList<>();
		Queue<StringBuilder> wordQueue = new LinkedList<>();
		nodeQueue.add(node);
		wordQueue.add(sb);
		while (!nodeQueue.isEmpty()) {
			TrieNode u = nodeQueue.remove();
			StringBuilder word = wordQueue.remove();
			if (u.isEnd()) {
				words.add(word.toString());
			}

			for (int i = 0; i < u.R; i++) {
				c = (char)('a' + i);
				TrieNode v = u.get(c);
				if (v != null) {
					StringBuilder newWord = new StringBuilder(word);
					newWord.append(c);
					nodeQueue.add(v);
					wordQueue.add(newWord);
				}
			}
		}
		return words;
	}

	public List<String> dfsAutoComplete(String prefix) {
		List<String> words = new LinkedList<>();
		if (prefix == null || prefix.length() == 0) return words;
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;
		for (int i = 0; node != null && i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (!node.containsKey(c)) return words;
			sb.append(c);
			node = node.get(c);
		}

		dfs(node, words, sb);
		return words;
	}

	public void dfs(TrieNode node, List<String> words, StringBuilder sb) {
		if (node.isEnd()) {
			words.add(sb.toString());
			if (getNumLinks(node) == 0) return;
		}

		for (int i = 0; i < node.R; i++) {
			char v = (char)('a' + i);
			if (node.containsKey(v)) {
				sb.append(v);
				dfs(node.get(v), words, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

	}

	private int getNumLinks(TrieNode node) {
		int count = 0;
		for (int i = 0; i < node.R; i++) {
			if (node.get((char)('a' + i)) != null) {
				count++;
			}
		}
		return count;
	}

	class TrieNode {
		TrieNode[] links;
		int R = 26;
		boolean isEnd;

		TrieNode() {
			links = new TrieNode[R];
		}

		boolean containsKey(char c) {
			return links[c - 'a'] != null;
		}

		void put(char c) {
			links[c - 'a'] = new TrieNode();
		}

		TrieNode get(char c) {
			return links[c - 'a'];
		}

		boolean isEnd() {
			return isEnd;
		}

		void setEnd() {
			isEnd = true;
		}
	}
}