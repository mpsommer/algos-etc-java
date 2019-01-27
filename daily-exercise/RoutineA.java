import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;
public class RoutineA {

	// TODO: heaps, rabin-karp djikstra, other famous algos.

	ListNode head;
	RoutineA() {}
	///////////////////////////////////////////
	////////        BinaryTrees        ////////
	///////////////////////////////////////////
	public void preOrder(Node root, List<Integer> list) {
	}

	public void inOrder(Node root, List<Integer> list) {
	}

	public void postOrder(Node root, List<Integer> list) {
	}

	public void levelOrder(Node root, List<Integer> list) {
	}

	public void spiralOrder(Node root, List<Integer> list) {
	}

	public void nodesAtLevel(Node root, int level, List<Integer> list) {
	}

	public int treeHeight(Node root) {
		return -1;
	}

	public int treeLevels(Node root) {
		return -1;
	}

	///////////////////////////////////////////
	////////     SinglyLinkedLists     ////////
	///////////////////////////////////////////
	public void addToFront(int val) {
	}

	public int listLength() {
		return -1;
	}

	public ListNode deleteNode(int val) {
		return new ListNode(-1);
	}
	public ListNode reverseList() {
		ListNode previous = null;
		return previous;
	}

	public void printList() {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	///////////////////////////////////////////
	////////          Search           ////////
	///////////////////////////////////////////
	public void bfs(GraphNode root, List<Integer> list) {
	}

	public void dfs(GraphNode root, List<Integer> list) {
	}

	public int recursiveBinarySearch(int[] arr, int low, int high, int target) {
		return -1;
	}

	public int iterativeBinarySearch(int[] arr, int low, int high, int target) {
		return -1;
	}

	///////////////////////////////////////////
	////////           Sort            ////////
	///////////////////////////////////////////
	public void insertionSort(int[] arr) {
	}

	public void mergeSort(int[] arr, int low, int high) {
	}

	private void merge(int[] arr, int low, int mid, int high) {
	}

	public void quickSort(int[] arr, int low, int high) {
	}

	private int partition(int[] arr, int low, int high) {
		return -1;
	}

	void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}