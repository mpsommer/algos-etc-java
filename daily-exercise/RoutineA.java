public class RoutineA {
	
	// TODO: heaps, rabin-karp djikstra, other famous algos.

	SinglyLinkedList list = new SinglyLinkedList();
	RoutineA() {
		list = new SinglyLinkedList();
	}
	///////////////////////////////////////////
	////////        BinaryTrees        ////////
	///////////////////////////////////////////
	public void preOrder(Node root) {
		System.out.println("In preOrder");
	}

	public void inOrder(Node root) {
		System.out.println("In inOrder");
	}

	public void postOrder(Node root) {
		System.out.println("In postOrder");
	}

	public void levelOrder(Node root) {
		System.out.println("In levelOrder");
	}

	public void spiralOrder(Node root) {
		System.out.println("In spiralOrder");
	}

	public void nodesAtLevel(Node root, int level) {
		System.out.println("In nodesAtLevel");
	}

	public void treeHeight(Node root) {
		System.out.println("In treeHeight");
	}

	public void treeLevels(Node root) {
		System.out.println("In treeLevels");
	}

	///////////////////////////////////////////
	////////     SinglyLinkedLists     ////////
	///////////////////////////////////////////
	public void addToFront(int val) {
		System.out.println("In addToFront");
	}

	public void addToTail(int val) {
		System.out.println("In addToTail");
	}

	public void listLength() {
		System.out.println("In listLength");
	}

	public Node deleteNode(int val) {
		System.out.println("In deleteNode");
		return new Node(-1);
	}

	///////////////////////////////////////////
	////////          Search           ////////
	///////////////////////////////////////////
	public void bfs(GraphNode root) {
		System.out.println("In bfs");
	}

	public void dfs(GraphNode root) {
		System.out.println("In dfs");
	}

	public int recursiveBinarySearch(int[] arr) {
		System.out.println("In recursiveBinarySearch");
		return -1;
	}

	public int iterativeBinarySearch(int[] arr) {
		System.out.println("In iterativeBinarySearch");
		return -1;
	}

	///////////////////////////////////////////
	////////           Sort            ////////
	///////////////////////////////////////////
	public void insertionSort(int[] arr) {
		System.out.println("In insertionSort");
	}

	public void mergeSort(int[] arr, int low, int high) {
		System.out.println("In mergeSort");
		merge(arr, low, low, low);
	}

	private void merge(int[] arr, int low, int mid, int high) {
		System.out.println("In Merge");
	}

	public void quickSort(int[] arr, int low, int high) {
		System.out.println("In quickSort");
		partition(arr, low, high);
	}

	private void partition(int[] arr, int low, int high) {
		System.out.println("In partition");
	}

}