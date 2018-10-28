import java.util.List;
import java.util.LinkedList;
public class GraphNode {
	int val;
	boolean visited;
	List<GraphNode> edges;
	public GraphNode(int v) {
		this.val = v;
		this.visited = false;
		this.edges = new LinkedList<>();
	}
	public void addEdge(GraphNode edge) {
		this.edges.add(edge);
	}
	public List<GraphNode> getEdges() {
		return edges;
	}
}