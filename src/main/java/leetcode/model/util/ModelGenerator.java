package leetcode.model.util;

import leetcode.model.ListNode;

public class ModelGenerator {

	public static ListNode create(int n) {

		if (n > 0) {
			ListNode node = new ListNode(1);
			ListNode temp = node;
			for (int i = 2; i <= n; i++) {
				temp.next = new ListNode(i);
				temp = temp.next;
			}
			return node;
		}
		return null;

	}
}
