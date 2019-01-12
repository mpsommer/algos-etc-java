
import java.util.Comparator;
class Node implements Comparator<Node> {
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
	public int compare(Node node1, Node node2) {
		if (node1.dist < node2.dist) {
			return -1;
		} else if (node1.dist > node2.dist) {
			return 1;
		} else {
			return 0;
		}
	}
}