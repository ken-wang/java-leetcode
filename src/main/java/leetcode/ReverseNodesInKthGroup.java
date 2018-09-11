package leetcode;

import leetcode.model.ListNode;

public class ReverseNodesInKthGroup {

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		int index = 0;
		ListNode prev = dummy;
		ListNode next = dummy.next;

		while (next != null) {
			index++;
			if (index % k == 0) {
				ListNode temp = next.next;
				next.next = null;
				prev = reverse(prev, prev.next);
				prev.next = temp;
				next = temp;
			} else {
				next = next.next;
			}

		}

		return dummy.next;
	}

	private ListNode reverse(ListNode previous, ListNode node) {

		ListNode current = node;
		ListNode prev = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;

			prev = current;
			current = next;
		}
		previous.next = prev;
		return node;

	}
}
