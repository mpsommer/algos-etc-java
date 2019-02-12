
class Node {
	public int node;
	public int dist;
	int val;
	Node left, right;

	public Node() {}

	public Node(int item) {
		val = item;
		left = null;
		right = null;
	}

	// Used for dijkstra in routineF
	public Node(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}