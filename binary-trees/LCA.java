import java.util.LinkedList;

public class LCA {

	public static int findLCA(Node node, int key1, int key2 ) {
		LinkedList<Integer> path1 = findPath(node, key1);
		LinkedList<Integer> path2 = findPath(node, key2);

		if (path1.size() < 1 || path2.size() < 1) {
			return -1;
		}

		int i = 0;
		while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
			i++;
		}
		return path1.get(i-1);
	}

	public static LinkedList<Integer> findPath(Node node, int key) {
		LinkedList<Integer> path = new LinkedList<>();
		findPath(node, key, path);
		return path;
	}

	public static boolean findPath(Node node, int key, LinkedList<Integer> path) {
		// If innitial node is null;
		if (node == null) {
			return false;
		}
		path.add(node.key);

		if (node.key == key) {
			return true;
		}

		if (node.left != null && findPath(node.left, key, path)) {
			return true;
		}

		if (node.right != null && findPath(node.right, key, path)) {
			return true;
		}

		// If no path found
		path.remove(path.size()-1);
		return false;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		LinkedList<Integer> path1 = findPath(tree.root, 2);
		LinkedList<Integer> path2 = findPath(tree.root, 4);
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(findLCA(tree.root, 2, 4));
	}
}