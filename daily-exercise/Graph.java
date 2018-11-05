// Used for Bellman-Ford in RoutineB.

public class Graph {
	// A class to represent a weighted edge in graph
	class Edge {
		int src, dest, weight;
		Edge() {
			src = dest = weight = 0;
		}
	};

	int V, E;
	Edge edge[];

	// Creates a graph with V vertices and E edges
	Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}
}
