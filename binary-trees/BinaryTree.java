import java.util.*;

public class BinaryTree {
	Node root;

	BinaryTree() {
		root = null;
	}

	public static void printPreOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.key + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	public static void printPostOrder(Node node) {
		if (node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.key + " ");
	}

	public static void printInOrder(Node node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.key + " ");
		printInOrder(node.right);
	}

	public static int getTreeHeight(Node node) {
		if (node == null || (node.left == null && node.right == null)) {
			return 0;
		}
		int leftHeight = getTreeHeight(node.left);
		int rightHeight = getTreeHeight(node.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		return rightHeight + 1;
	}

	public static int getTreeLevels(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = getTreeLevels(node.left);
		int rightHeight = getTreeLevels(node.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		return rightHeight + 1;
	}

	public static void printLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.key + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void printSpiralOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int dir = 0;
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.key + " ");
			if (dir % 2 == 0) {
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			} else {
				if (node.right != null) {
					queue.add(node.right);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
			}
			dir++;
		}
	}

	public static void printNodesAtLevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.key + " ");
		}
		if (level > 1) {
			printNodesAtLevel(root.left, level - 1);
			printNodesAtLevel(root.right, level - 1);
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("preorder traversal: ");
		printPreOrder(tree.root); // 1 2 4 5 3
		System.out.println("\ninorder traversal: ");
		printInOrder(tree.root); // 4 2 5 1 3
		System.out.println("\npostorder traversal: ");
		printPostOrder(tree.root); // 4 5 2 3 1
		System.out.println("\nlevelorder traversal: ");
		printLevelOrder(tree.root); // 1 2 3 4 5
		System.out.println("\nTree Levels: " + getTreeLevels(tree.root)); // 3
		System.out.println("Tree height: " + getTreeHeight(tree.root)); // 2
		System.out.println("Tree nodes in level 1: "); // 1
		printNodesAtLevel(tree.root, 1);
		System.out.println("\nTree nodes in level 2: "); // 2 3 
		printNodesAtLevel(tree.root, 2);
		System.out.println("\nTree nodes in level 3: "); // 4 5
		printNodesAtLevel(tree.root, 3);
		System.out.println();
		printSpiralOrder(tree.root); //1 2 3 5 4
		System.out.println();
	}
}