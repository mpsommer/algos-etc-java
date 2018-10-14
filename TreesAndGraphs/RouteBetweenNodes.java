import java.util.*;

public class RouteBetweenNodes {
	static class Node {
		int data;
		boolean visited;
		List<Node> edges;
		public Node(int v) {
			this.data = v;
			this.visited = false;
			this.edges = new LinkedList<>();
		}
		public void addEdge(Node edge) {
			this.edges.add(edge);
		}
		public List<Node> getEdges() {
			return edges;
		}
	}

	static boolean findRoute(Node start, Node end) {
		List<Node> queue = new LinkedList<>();
		start.visited = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			Node r = queue.remove(0);
			if (r == end) {
				return true;
			}
			for (Node n: r.edges) {
				if (n.visited == false) {
					n.visited = true;
					queue.add(n);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n0.addEdge(n1);
		n0.addEdge(n4);
		n0.addEdge(n5);
		n1.addEdge(n3);
		n1.addEdge(n4);
		n2.addEdge(n1);
		n3.addEdge(n2);
		n3.addEdge(n4);
		System.out.println(findRoute(n0, n2));

	}
}