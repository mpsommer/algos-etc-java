import java.lang.StringBuilder;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TrieComplete {

	private TrieNode root;
	static int index;

	public TrieComplete() {
		root = new TrieNode();
	}

	// Inserts a word into a Trie.
	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
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
		for (char c : word.toCharArray()) {
			if (node.containsKey(c)) {
				node = node.get(c);
			} else {
				return null;
			}
		}
		return node;
	}

	public List<String> bfsAutoComplete(String prefix) {
		List<String> words = new LinkedList<>();
		if (prefix.length() == 0)
			return words;
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;

		// build prefix string first;
		int i = 0;
		char c;
		while (node != null && i < prefix.length()) {
			c = prefix.charAt(i);
			if (node.containsKey(c)) {
				sb.append(c);
				node = node.get(c);
			} else {
				// If prefix does not exist int trie
				return words;
			}
			i++;
		}
		// bfs
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
			for (i = 0; i < u.R; i++) {
				TrieNode v = u.links[i];
				if (v != null) {
					StringBuilder next = new StringBuilder(word);
					next.append((char) ('a' + i));
					nodeQueue.add(v);
					wordQueue.add(next);
				}
			}
		}
		return words;
	}

	public List<String> dfsAutoComplete(String prefix) {
		List<String> words = new LinkedList<>();
		if (prefix.length() == 0)
			return words;
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;

		// build prefix string first;
		int i = 0;
		char c;
		while (node != null && i < prefix.length()) {
			c = prefix.charAt(i);
			if (node.containsKey(c)) {
				sb.append(c);
				node = node.get(c);
			} else {
				// If prefix does not exist int trie
				return words;
			}
			i++;
		}
		dfs(node, words, sb);
		return words;
	}

	public void dfs(TrieNode node, List<String> wordList, StringBuilder chars) {
		if (node.isEnd()) {
			StringBuilder sb = new StringBuilder(chars);
			wordList.add(sb.toString());
		}
		if (node.isEnd() && getNumLinks(node) == 0) {
			return;
		}
		for (int i = 0; i < node.R; i++) {
			char v = (char) (i + 'a');
			if (node.containsKey(v)) {
				chars.append(v);
				dfs(node.get(v), wordList, chars);
				chars.deleteCharAt(chars.length() - 1);
			}
		}
	}


	private TrieNode getLongestPrefixNode(String word) {
		TrieNode node = root;
		TrieNode previous = root;
		for (char c : word.toCharArray()) {
			if (node.containsKey(c)) {
				previous = node;
				node = node.get(c);
			} else {
				return previous;
			}
		}
		return node;
	}

	// Returns true if the word is in the Trie
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	public boolean startsWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

	public String longestCommonPrefix() {
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;
		while (getNumLinks(node) == 1 && !node.isEnd()) {
			sb.append((char) ('a' + index));
			node = node.links[index];

		}
		return sb.toString();
	}

	private int getNumLinks(TrieNode node) {
		int count = 0;
		for (int i = 0; i < node.links.length; i++) {
			if (node.links[i] != null) {
				index = i;
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

		public boolean containsKey(char c) {
			return links[c - 'a'] != null;
		}

		public TrieNode get(char c) {
			return links[c - 'a'];
		}

		public void put(char c) {
			links[c - 'a'] = new TrieNode();
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd() {
			isEnd = true;
		}
	}
}