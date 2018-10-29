import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
public class RoutineAComplete {

	// TODO: heaps, rabin-karp djikstra, other famous algos.

	ListNode head;
	RoutineA() {}
	///////////////////////////////////////////
	////////        BinaryTrees        ////////
	///////////////////////////////////////////
	public void preOrder(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

	public void inOrder(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

	public void postOrder(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}

	public void levelOrder(Node root, List<Integer> list) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			list.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public void spiralOrder(Node root, List<Integer> list) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int direc = 1;
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			list.add(node.val);
			if (direc % 2 == 0) {
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
			direc++;
		}
	}

	public void nodesAtLevel(Node root, int level, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			list.add(root.val);
		}
		if (level > 1) {
			nodesAtLevel(root.left, level - 1, list);
			nodesAtLevel(root.right, level - 1, list);
		}
	}

	public int treeHeight(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		return rightHeight + 1;
	}

	public int treeLevels(Node root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = treeLevels(root.left);
		int rightHeight = treeLevels(root.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		return rightHeight + 1;
	}

	///////////////////////////////////////////
	////////     SinglyLinkedLists     ////////
	///////////////////////////////////////////
	public void addToFront(int val) {
		ListNode node = new ListNode(val);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public int listLength() {
		ListNode node = head;
		int count = 0;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	public ListNode deleteNode(int val) {
		ListNode node = head;
		if (head != null && head.val == val) {
			head = head.next;
			return node;
		}

		while (node.next != null) {
			if (node.next.val == val) {
				ListNode result = node;
				node.next = node.next.next;
				return result;
			}
			node = node.next;
		}
		return head;
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
		Queue<GraphNode> queue = new LinkedList<>();
		root.visited = true;
		queue.add(root);
		while (!queue.isEmpty()) {
			GraphNode node = queue.remove();
			list.add(node.val);
			for (GraphNode n: node.edges) {
				if (n.visited == false) {
					n.visited = true;
					queue.add(n);
				}
			}
		}
		System.out.println();
	}

	public void dfs(GraphNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		root.visited = true;
		for (GraphNode node: root.edges) {
			if (node.visited == false) {
				dfs(node, list);
			}
		}
	}

	public int recursiveBinarySearch(int[] arr, int low, int high, int target) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (target < arr[mid]) {
				return recursiveBinarySearch(arr, low, mid - 1, target);
			}
			return recursiveBinarySearch(arr, mid + 1, high, target);
		}
		return -1;
	}

	public int iterativeBinarySearch(int[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (target < arr[mid]) {
				high = mid - 1;
			} else {
				low  = mid + 1;
			}
		}
		return -1;
	}

	///////////////////////////////////////////
	////////           Sort            ////////
	///////////////////////////////////////////
	public void insertionSort(int[] arr) {
		int i, j, key;
		for (i = 1; i < arr.length; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private void merge(int[] arr, int low, int mid, int high) {
		int i, j, k;
		int[] left = new int[mid + 1 - low];
		int[] right = new int[high - mid];
		for (i = 0; i < left.length; i++) {
			left[i] = arr[low + i];
		}
		for (j = 0; j < right.length; j++) {
			right[j] =  arr[mid + 1 + j];
		}

		i = 0;
		j = 0;
		k = low;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}

		while (j < right.length) {
			arr[k++] = right[j++];
		}

	}

	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arr, low, high);
			quickSort(arr, low, partitionIndex -1);
			quickSort(arr, partitionIndex + 1, high);

		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int lessThan = low - 1;

		for (int greaterThan = low; greaterThan < high; greaterThan++) {
			if (arr[greaterThan] <= pivot) {
				lessThan++;
				swap(arr, lessThan, greaterThan);
			}
		}
		swap(arr, lessThan + 1, high);
		return lessThan + 1;
	}

	void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}