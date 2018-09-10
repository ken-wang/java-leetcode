package leetcode;

import leetcode.model.ListNode;

public class MiddleOfTheLinkedList {

	public ListNode middleNode(ListNode head) {
		int depth = getDepth(0, head);
		int middle = depth / 2;
		return getMiddleNode(middle, head);
	}

	private int getDepth(int depth, ListNode node) {
		if (node == null) {
			return depth;
		} else {
			return getDepth(depth + 1, node.next);
		}
	}

	private ListNode getMiddleNode(int depth, ListNode node) {
		if (depth == 0) {
			return node;
		} else {
			return getMiddleNode(depth - 1, node.next);
		}
	}
}
