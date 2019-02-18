import java.util.List;
import java.util.ArrayList;

public class DriverF {
	public static void printArr(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		RoutineF rtF = new RoutineF();

		// Minimum spanning tree.
		int graph[][] = new int[][] {
			{0, 2, 0, 6, 0},
			{2, 0, 3, 8, 5},
			{0, 3, 0, 0, 7},
			{6, 8, 0, 0, 9},
			{0, 5, 7, 9, 0}
		};

		// 0 - 1: 2
		// 1 - 2: 3
		// 0 - 3: 6
		// 1 - 4: 5
		// rtF.prims(graph);

		// Sorting
		int[] arr = {12, 11, 13, 5, 6, 7};
		rtF.heapSort(arr);
		// printArr(arr);

		// Shortest Path
		List<List<Node>> adj = new ArrayList<List<Node>>();
		// Initialize list for every node
		for (int i = 0; i < 5; i++) {
			List<Node> item = new ArrayList<Node>();
			adj.add(item);
		}
		// Inputs for the DPQ graph
		adj.get(0).add(new Node(1, 9));
		adj.get(0).add(new Node(2, 6));
		adj.get(0).add(new Node(3, 5));
		adj.get(0).add(new Node(4, 3));
		adj.get(4).add(new Node(3, 1));
		adj.get(2).add(new Node(1, 2));
		adj.get(2).add(new Node(3, 4));
		// Dist from 0 to 0: 0
		// Dist from 0 to 1: 8
		// Dist from 0 to 2: 6
		// Dist from 0 to 3: 4
		// Dist from 0 to 4: 3
		// Path from 0 to 3: [0, 4, 3]
		rtF.dijkstra(adj, 0, 3);

	}
}