package leetcode;

import leetcode.model.ListNode;

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode nth = getIndex(head, n);
		ListNode node = head;
		if (nth == null) {
			return head.next;
		}
		while (nth.next != null) {
			node = node.next;
			nth = nth.next;
		}
		node.next = node.next.next;
		return head;

	}

	private ListNode getIndex(ListNode node, int index) {

		ListNode temp = node;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;

	}

}
