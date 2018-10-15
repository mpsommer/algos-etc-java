import java.util.*;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		 key = item;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	Node root;

	BinaryTree() {
		root = null;
	}

	static void printPreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	static void printInOrder(Node node) {
		if (node == null) {
			return;
		}

		printInOrder(node.left);
		System.out.print(node.key + " ");
		printInOrder(node.right);
	}

	static void printPostOrder(Node node) {
		if (node == null) {
			return;
		}

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.key + " ");
	}

	static int getTreeHeight(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		int lHeight = getTreeHeight(root.left);
		int rHeight = getTreeHeight(root.right);
		if (lHeight > rHeight) {
			return lHeight + 1;
		}
		return rHeight + 1;
	}

	static int getTreeLevels(Node root) {
		if (root == null) {
			return 0;
		}
		int lLevel = getTreeLevels(root.left);
		int rLevel = getTreeLevels(root.right);
		if (lLevel > rLevel) {
			return lLevel + 1;
		}
		return rLevel + 1;
	}

	static void printLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.key + " ");

			if(node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	static void printSpiralOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int dir = 0;
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.key + " ");
			if(dir % 2 == 0) {
				if(node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			} else {
				if (node.right != null) {
					queue.add(node.right);
				}
				if(node.left != null) {
					queue.add(node.left);
				}
			}
			dir++;
		}
		
	}

	public static void printLevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.key + " ");
		} 
		if (level > 1) {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
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
		printPreOrder(tree.root);
		System.out.println("\ninorder traversal: ");
		printInOrder(tree.root);
		System.out.println("\npostorder traversal: ");
		printPostOrder(tree.root);
		System.out.println("\nlevelorder traversal: ");
		printLevelOrder(tree.root);
		System.out.println("\nTree Levels: " + getTreeLevels(tree.root));
		System.out.println("Tree height: " + getTreeHeight(tree.root));
		System.out.println("Tree nodes in level 1: ");
		printLevel(tree.root, 1);
		System.out.println("\nTree nodes in level 2: ");
		printLevel(tree.root, 2);
		System.out.println("\nTree nodes in level 3: ");
		printLevel(tree.root, 3);
		System.out.println();
		printSpiralOrder(tree.root);
		System.out.println();
	}
}