package leetcode;

import leetcode.model.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return handle(l1, l2, 0);
	}

	private ListNode handle(ListNode l1, ListNode l2, int overflow) {

		if (l1 == null && l2 == null) {
			if (overflow > 0) {
				return new ListNode(overflow);
			} else {
				return null;
			}
		}
		if (l2 == null) {
			l2 = new ListNode(0);
		} else if (l1 == null) {
			l1 = new ListNode(0);
		}

		int value = l1.val + l2.val + overflow;
		ListNode node = convert(value % 10);
		if (value / 10 > 0) {
			node.next = handle(l1.next, l2.next, 1);
		} else {
			node.next = handle(l1.next, l2.next, 0);
		}
		return node;
	}

	private ListNode convert(int n) {
		if (n / 10 == 0) {
			return new ListNode(n);
		} else {
			ListNode node = new ListNode(n % 10);
			node.next = convert(n / 10);
			return node;
		}
	}

}
