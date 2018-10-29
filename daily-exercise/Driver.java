import java.util.List;
import java.util.LinkedList;
public class Driver {
	public static void printArr(int[] arr) {
		for (int elem: arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		RoutineA rtA = new RoutineA();

		//// BinaryTree
		System.out.println("#### Binary Trees ####");
		List<Integer> list = new LinkedList<>();
		rtA.preOrder(tree.root, list);
		System.out.println(list); // 1 2 4 5 3
		list = new LinkedList<>();
		rtA.inOrder(tree.root, list);
		System.out.println(list); // 4 2 5 1 3
		list = new LinkedList<>();
		rtA.postOrder(tree.root, list);
		System.out.println(list); // 4 5 2 3 1
		list = new LinkedList<>();
		rtA.levelOrder(tree.root, list);
		System.out.println(list); // 1 2 3 4 5
		list = new LinkedList<>();
		rtA.spiralOrder(tree.root, list);
		System.out.println(list); // 1 3 2 5 4
		list = new LinkedList<>();
		rtA.nodesAtLevel(tree.root, 0, list);
		System.out.println(list); // ""
		list = new LinkedList<>();
		rtA.nodesAtLevel(tree.root, 1, list);
		System.out.println(list); // 1
		list = new LinkedList<>();
		rtA.nodesAtLevel(tree.root, 2, list);
		System.out.println(list); // 2 3
		list = new LinkedList<>();
		rtA.nodesAtLevel(tree.root, 3, list);
		System.out.println(list); // 4 5 
		System.out.println(rtA.treeHeight(tree.root)); // 2
		System.out.println(rtA.treeLevels(tree.root)); // 3

		//// LinkedList
		System.out.println("#### Singly Linked List ####");
		rtA.addToFront(5);
		rtA.addToFront(4);
		rtA.addToFront(3);
		rtA.addToFront(2);
		rtA.printList(); // 2 3 4 5
		rtA.addToFront(1);
		rtA.addToFront(0);
		rtA.printList(); // 0 1 2 3 4 5
		System.out.println(rtA.listLength());
		rtA.deleteNode(2);
		rtA.printList(); //0 1 3 4 5

		//// Search
		System.out.println("#### Search ####");
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
		list = new LinkedList<>();
		rtA.bfs(n0, list);
		System.out.println(list); // 0 1 4 5 3 2
		n0.visited = false;
		n1.visited = false;
		n2.visited = false;
		n3.visited = false;
		n4.visited = false;
		n5.visited = false;
		list = new LinkedList<>();
		rtA.dfs(n0, list);
		System.out.println(list); // 0 1 3 2 4 5
		int[] bsArr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(rtA.recursiveBinarySearch(bsArr, 0, bsArr.length-1, 3));
		System.out.println(rtA.iterativeBinarySearch(bsArr, 0, bsArr.length-1, 3));

		//// Sort
		int[] insArr ={3,6,12,9,34,23,1,78};
		rtA.insertionSort(insArr);
		printArr(insArr);
		int[] mergeArr ={3,6,12,9,34,23,1,78};
		rtA.mergeSort(mergeArr, 0, mergeArr.length-1);
		printArr(mergeArr);
		int[] quickArr ={3,6,12,9,34,23,1,78};
		rtA.quickSort(quickArr, 0, quickArr.length - 1);
		printArr(quickArr);

	}
}