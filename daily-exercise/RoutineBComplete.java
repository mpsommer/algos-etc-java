import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Stack;

public class RoutineBComplete {

	// TODO: heaps, rabin-karp, topological sort, djikstra, other famous algos.
	RoutineBComplete() {}

	///////////////////////////////////////////
	////////       Shortest path       ////////
	///////////////////////////////////////////
	/**
	 * 
	 * @param graph
	 * @param src
	 * @return
	 * runtime: O(VE)
	 */
	public int[] bellmanFord(Graph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];
		int[] parent = new int[V];
		Arrays.fill(parent, -1);
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					parent[v] = u;
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
		int current = 4;
		LinkedList<Integer> path = new LinkedList<>();
		while (current != -1) {
			path.add(0, current);
			current = parent[current];
		}
		System.out.println(src + " to 4: " + path);
		return dist;
	}

	///////////////////////////////////////////
	////////        BinaryTrees        ////////
	///////////////////////////////////////////
	/**
	 * 
	 * @param root
	 * @param list
	 * runtime: O(n)
	 * root, left, right.
	 * [1, 2, 4, 5, 3]
	 */
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

	/**
	 * 
	 * @param root
	 * @param list
	 * runtime O(n)
	 * left, root, right.
	 * [4, 2, 5, 1, 3]
	 */
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

	/**
	 * 
	 * @param root
	 * @param list
	 * runtime: O(n)
	 * left, right, root.
	 * [4, 5, 2, 3, 1]
	 */
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

	/**
	 * runtime: O(n)
	 * [1, 5, 9]
	 */
	public List<Integer> sumLevelVals(Node root) {
		List<Integer> result = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int sum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.remove();
				sum += node.val;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(sum);
		}
		return result;
	}

	
	///////////////////////////////////////////
	////////      Matrix Traversal     ////////
	///////////////////////////////////////////
	
	public void rowTraversal(int[][] M) {
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void colTraversal(int[][] M) {
		int rowLength = M.length;
		int colLength = M[0].length;
		for (int i = 0; i < colLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				System.out.print(M[j][i] + " ");
			}
			System.out.println();
		}
	}

	public void traverseTopLeftToBottomRight(int[][] M) {
		int i, j, k;
		int rowLength = M.length;
		int colLength = M[0].length;
		for (k = 0; k < rowLength; k++) {
			i = k;
			j = 0;
			while (i >= 0) {
				System.out.print(M[i][j] + " ");
				i--;
				j++;
			}
			System.out.println();
		}
		for (k = 1; k < colLength; k++) {
			i = M.length - 1;
			j = k;
			while (j < colLength) {
				System.out.print(M[i][j] + " ");
				i--;
				j++;
			}
			System.out.println();
		}
	}

	public void traverseTopRightToBottomLeft(int[][] M) {
		int i, j, k;
		int rowLength = M.length;
		int colLength = M[0].length;
		for (k = colLength - 1; k > 0; k--) {
			i = 0;
			j = k;
			while (j < colLength) {
				System.out.print(M[i++][j++] + " ");
			}
			System.out.println();
		}
		for (k = 0; k < rowLength; k++) {
			i = k;
			j = 0;
			while (i < rowLength) {
				System.out.print(M[i++][j++] + " ");
			}
			System.out.println();
		}
	}
}