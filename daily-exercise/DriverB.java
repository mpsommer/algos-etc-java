import java.util.List;
import java.util.LinkedList;

public class DriverB {
	public static void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RoutineB rtB = new RoutineB();
		/////     Bellman Ford
		int V = 5; // Number of vertices in graph
		int E = 8; // Number of edges in graph

		Graph graph = new Graph(V, E);

		// add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		int[] dist = rtB.bellmanFord(graph, 0);
		System.out.println("#### Bellman-Ford ####");
		System.out.println("Dist from 0: " + dist[0]); // 0
		System.out.println("Dist from 1: " + dist[1]); // -1
		System.out.println("Dist from 2: " + dist[2]); // 2
		System.out.println("Dist from 3: " + dist[3]); // -2
		System.out.println("Dist from 4: " + dist[4]); // 1

		System.out.println("#### Binary Trees Iterative ####");
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		List<Integer> list = new LinkedList<>();
		rtB.IterPreOrder(tree.root, list);
		System.out.println(list); // 1 2 4 5 3
		list = new LinkedList<>();
		rtB.IterInOrder(tree.root, list);
		System.out.println(list); // 4 2 5 1 3
		list = new LinkedList<>();
		rtB.IterPostOrder(tree.root, list);
		System.out.println(list); // 4 5 2 3 1

		/////     Matrix Traversal
		int[][] m = new int[4][5];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j <m[i].length; j++)
			m[i][j] = j;
		}
		rtB.rowTraversal(m); // 0 1 2 3 4
		System.out.println();
		rtB.colTraversal(m); // 0 1 2 3 4
		System.out.println();
		rtB.traverseTopLeftToBottomRight(m);
		System.out.println();
		rtB.traverseTopRightToBottomLeft(m);
		System.out.println();
	}
}