package leetcode;

import leetcode.model.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode nextNext = swapPairs(head.next.next);
		
		ListNode newHead = head.next;
		newHead.next = head;
		newHead.next.next = nextNext;
		return newHead;
	}

}
