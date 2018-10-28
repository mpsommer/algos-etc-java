public class Driver {


	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		RoutineA rtA = new RoutineA();

		//// BinaryTree
		rtA.preOrder(tree.root);
		rtA.inOrder(tree.root);
		rtA.postOrder(tree.root);
		rtA.levelOrder(tree.root);
		rtA.spiralOrder(tree.root);
		rtA.nodesAtLevel(tree.root, 0);
		rtA.nodesAtLevel(tree.root, 1);
		rtA.nodesAtLevel(tree.root, 2);
		rtA.nodesAtLevel(tree.root, 4);
		rtA.treeHeight(tree.root);
		rtA.treeLevels(tree.root);

		//// LinkedList
		rtA.addToFront(1);
		rtA.addToTail(2);
		rtA.listLength();
		rtA.deleteNode(1);

		//// Search
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		n0.addEdge(n1);
		n0.addEdge(n4);
		n0.addEdge(n5);
		n1.addEdge(n3);
		n1.addEdge(n4);
		n2.addEdge(n1);
		n3.addEdge(n2);
		n3.addEdge(n4);
		int[] bfsArr = {1,2,3,4,5,6,7,8,9,10};
		rtA.bfs(n1);
		rtA.dfs(n1);
		rtA.recursiveBinarySearch(bfsArr);
		rtA.iterativeBinarySearch(bfsArr);

		//// Sort
		int[] insArr ={3,6,12,9,34,23,1,78};
		rtA.insertionSort(insArr);
		int[] mergeArr ={3,6,12,9,34,23,1,78};
		rtA.mergeSort(mergeArr, 0, mergeArr.length-1);
		int[] quickArr ={3,6,12,9,34,23,1,78};
		rtA.quickSort(quickArr, 0, quickArr.length - 1);

	}
}