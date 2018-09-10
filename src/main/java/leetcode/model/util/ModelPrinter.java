package leetcode.model.util;

import leetcode.model.ListNode;

public class ModelPrinter {
	public static void print(ListNode node) {
		if (node == null) {
			System.out.print("nil");
		} else {
			System.out.print(node.val + "->");
			print(node.next);
		}
	}
}
