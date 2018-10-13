public class LinkedList {
	Node head = null;
	public LinkedList() {
		
	}

	static class Node {
		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}

	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = head;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	Node deleteNode(int data) {
		Node n = head;
		// if head is where we find the data.
		if (n != null && n.data == data ) {
			head = head.next;
			return n;
		}

		// if data is in list but not in head.
		while (n.next != null) {
			if (n.next.data == data) {
				Node result = n.next;
				n.next = n.next.next;
				return result;
			}
			n = n.next;
		}

		// if data is not in list.
		return head;
	}

	public static void printList(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		Node foo = list.deleteNode(8);
		System.out.println("foo = " + foo.data);
		printList(list.head);

	}
}