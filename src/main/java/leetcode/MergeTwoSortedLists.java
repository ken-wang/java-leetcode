package leetcode;

import leetcode.model.ListNode;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode node = null;

		if (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				node = new ListNode(l1.val);
				node.next = mergeTwoLists(l1.next, l2);
			} else {
				node = new ListNode(l2.val);
				node.next = mergeTwoLists(l1, l2.next);
			}

		} else if (l1 != null && l2 == null) {
			node = l1;
		} else if (l1 == null && l2 != null) {
			node = l2;
		}
		return node;

	}
}
