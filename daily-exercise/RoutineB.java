import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;
import java.util.Arrays;

public class RoutineB {

	// TODO: heaps, rabin-karp Bellman-ford, topological sort, djikstra, other famous algos.
	RoutineB() {}

	///////////////////////////////////////////
	////////       Shortest path       ////////
	///////////////////////////////////////////
	/**
	 * 
	 * @param graph
	 * @param src
	 * @return
	 * runtime: O(VE)
	 */
	public int[] bellmanFord(Graph graph, int src) {
		int[] dist = new int[0];
		return dist;
	}

	///////////////////////////////////////////
	////////        BinaryTrees        ////////
	///////////////////////////////////////////
	/**
	 * 
	 * @param root
	 * @param list
	 * runtime: O(n)
	 * root, left, right.
	 * [1, 2, 4, 5, 3]
	 */
	public void IterPreOrder(Node root, List<Integer> list) {

	}

	/**
	 * 
	 * @param root
	 * @param list
	 * runtime O(n)
	 * left, root, right.
	 * [4, 2, 5, 1, 3]
	 */
	public void IterInOrder(Node root, List<Integer> list) {
	}

	/**
	 * 
	 * @param root
	 * @param list
	 * runtime: O(n)
	 * left, right, root.
	 * [4, 5, 2, 3, 1]
	 */
	public void IterPostOrder(Node root, List<Integer> list) {
	}

	/**
	 * runtime: O(n)
	 * [1, 5, 9]
	 */
	public List<Integer> sumLevelVals(Node root) {
		List<Integer> result = new LinkedList<>();
		return result;
	}

	///////////////////////////////////////////
	////////      Matrix Traversal     ////////
	///////////////////////////////////////////
	
	public void rowTraversal(int[][] M) {
	}

	public void colTraversal(int[][] M) {
	}

	public void traverseTopLeftToBottomRight(int[][] M) {
	}

	public void traverseTopRightToBottomLeft(int[][] M) {
	}
}