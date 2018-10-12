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
		System.out.println();
	}
}