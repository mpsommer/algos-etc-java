public class LinkedList {
	Node head = null;
	public LinkedList() {
		
	}

	static class Node {
		Node next = null;
		int val;
		public Node(int d) {
			val = d;
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

	Node deleteNode(int val) {
		Node n = head;
		// if head is where we find the val.
		if (n != null && n.val == val ) {
			head = head.next;
			return n;
		}

		// if val is in list but not in head.
		while (n.next != null) {
			if (n.next.val == val) {
				Node result = n.next;
				n.next = n.next.next;
				return result;
			}
			n = n.next;
		}

		// if val is not in list.
		return head;
	}

	public static void printList(Node node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}


	public static void printKthLast(Node head, int k) {
		int count = 0;
		Node node = head;
		while (node != null) {
			count++;
			node = node.next;
		}
		count = count - k;
		node = head;
		while (count > 0) {
			node = node.next;
			count--;
		}
		System.out.println(node.val);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(6);
		list.appendToTail(7);
		list.appendToTail(8);
		list.appendToTail(9);
		list.appendToTail(10);

		Node foo = list.deleteNode(8);
		System.out.println("foo = " + foo.val);
		printList(list.head);
		System.out.println();
		printKthLast(list.head, 3);
	}
}