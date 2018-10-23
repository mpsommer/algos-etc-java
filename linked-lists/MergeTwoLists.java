public class MergeTwoLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode start = new ListNode(0);
		ListNode current = start;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = new ListNode(l1.val);
				l1 = l1.next;
				current = current.next;
			} else {
				current.next = new ListNode(l2.val);
				l2 = l2.next;
				current = current.next;
			}
		}
		current.next = (l1 != null) ? l1 : l2;
		return start.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);

		ListNode node = mergeTwoLists(l1, l2);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}