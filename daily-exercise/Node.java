
class Node {
	public int node;
	public int dist;
	public int val;
	public Node left, right;
	public Node next;

	public Node() {}

	// For binary trees and linked lists.
	public Node(int val) {
		this.val = val;
	}

	// For Djikstra
	public Node(int val, int dist) {
		this.val = val;
		this.dist = dist;
	}
}