public class RoutineF {

	RoutineF() {}

	///////////////////////////////////////////
	//////// Minimmum Spanning Tree    ////////
	///////////////////////////////////////////
	// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
	public void prims(int[][] graph) {
		int V = graph.length;
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		
		for (int count = 0; count < V - 1; count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		// print the MST.
		for (int i = 1; i < V; i++) {
			System.out.println(parent[i] + " - " + i + ": " + graph[i][parent[i]]);
		}
	}

	private int minKey(int[] key, boolean[] mstSet) {
		int min = Integer.MAX_VALUE;
		int minIndex= -1;
		for (int i = 0; i < key.length; i++) {
			if (!mstSet[i] && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	///////////////////////////////////////////
	////////          Sorting          ////////
	///////////////////////////////////////////
	// https://www.geeksforgeeks.org/heap-sort/
	public void heapSort(int[] arr) {
		int n = arr.length;

		// Build heap.
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	public void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if (l < n && arr[l] > arr[largest]) largest = l;
		if (r < n && arr[r] > arr[largest]) largest = r;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}
}