import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class RoutineBComplete {

	// TODO: heaps, rabin-karp, topological sort, djikstra, other famous algos.
	RoutineB() {}

	///////////////////////////////////////////
	////////       Shortest path       ////////
	///////////////////////////////////////////
	public int[] bellmanFord(Graph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
				}
			}
		}
		for (int j = 0; j < E; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Negative weight cycle detected");
			}
		}
		return dist;
	}

	///////////////////////////////////////////
	////////        BinaryTrees        ////////
	///////////////////////////////////////////
	public void IterPreOrder(Node root, List<Integer> list) {
		if (root == null) return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	public void IterInOrder(Node root, List<Integer> list) {
		if (root == null) return;
		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || stack.size() > 0) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			list.add(current.val);
			current = current.right;
		}
	}

	public void IterPostOrder(Node root, List<Integer> list) {
		if (root == null) return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		Node previous = null;
		while (!stack.isEmpty()) {
			Node current = stack.peek();
			if (previous == null ||
				previous.left == current ||
					previous.right == current) {
							if (current.left != null) {
								stack.push(current.left);
							} else if (current.right != null) {
								stack.push(current.right);
							} else {
								stack.pop();
								list.add(current.val);
							}
			} else if (current.left == previous) {
				if (current.right != null) {
					stack.push(current.right);
				} else {
					stack.pop();
					list.add(current.val);
				}
			} else if (current.right == previous) {
				stack.pop();
				list.add(current.val);
			}
			previous = current;
		}
	}
}