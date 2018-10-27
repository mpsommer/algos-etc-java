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

public class BinarySearchTree {
	Node root;

	BinarySearchTree() {
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

	public static void fixIncorrectBST(Node root) {
		List<Integer> list = new ArrayList<>();
		BSTValuesToList(list, root);
		Collections.sort(list);
		correctBSTValues(list, root);

	}
	public static void correctBSTValues(List<Integer> list, Node root) {
		if (root == null ) {
			return;
		}
		correctBSTValues(list, root.left);
		root.key = list.remove(0);
		correctBSTValues(list, root.right);
	}
	public static void BSTValuesToList(List<Integer> list, Node root) {
		if (root == null) {
			return;
		}
		BSTValuesToList(list, root.left);
		list.add(root.key);
		BSTValuesToList(list, root.right);
	}

	public static void main(String[] args) {
		BinarySearchTree bstIncorrect = new BinarySearchTree();
		bstIncorrect.root = new Node(10);
		bstIncorrect.root.left = new Node(25);
		bstIncorrect.root.left.left = new Node(3);
		bstIncorrect.root.left.left = new Node(7);
		bstIncorrect.root.left.right = new Node(8);
		bstIncorrect.root.right = new Node(20);
		bstIncorrect.root.right.left = new Node(15);
		bstIncorrect.root.right.right = new Node(5);
		printInOrder(bstIncorrect.root);
		fixIncorrectBST(bstIncorrect.root);
		System.out.println();
		printInOrder(bstIncorrect.root);

	}
}