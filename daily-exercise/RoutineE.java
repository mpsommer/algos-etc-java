import java.util.Arrays;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

public class RoutineE {
	///////////////////////////////////////////
	//////// Print shortest path //////////////
	///////////////////////////////////////////
	public int[] bellmanFord(Graph graph, int src, int dest) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];
		int[] pred = new int[V];
		Arrays.fill(pred, 0, pred.length, -1);


		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					pred[v] = u;
				}
			}
		}
		for (int j = 0; j < E; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Negative weight cycle detected");
			}
		}

		int current = dest;
		List<Integer> path = new LinkedList<>();
		while (current != -1) {
			path.add(0, current);
			current = pred[current];
		}
		System.out.println("Path from 0 to 4: " + path);
		return dist;
	}

	public List<GraphNode> bfs(GraphNode start, GraphNode end, GraphNode[] pred) {
		Queue<GraphNode> queue = new LinkedList<>();
		List<GraphNode> path = new LinkedList<>();
		start.visited = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			GraphNode node = queue.remove();
			if (node.val == end.val) {
				GraphNode current = end;
				while (current != null) {
					path.add(0, current);
					current = pred[current.data];
				}
				return path;
			}
			for (GraphNode n: node.edges) {
				if (n.visited == false) {
					n.visited = true;
					queue.add(n);
					pred[n.val] = node;
				}
			}
		}
	}

}