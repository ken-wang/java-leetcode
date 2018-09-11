package leetcode.model.util;

import leetcode.model.ListNode;

public class ModelPrinter {
	public static void print(ListNode node) {
		if (node == null) {
			System.out.println("nil");
		} else {
			System.out.print(node.val + "->");
			print(node.next);
		}
	}
}
