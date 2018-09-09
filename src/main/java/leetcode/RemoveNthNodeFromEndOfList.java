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

	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
		print(obj.removeNthFromEnd(create(5), 2));
		System.out.println();
		print(obj.removeNthFromEnd(create(1), 1));
		System.out.println();
		print(obj.removeNthFromEnd(create(2), 1));
		System.out.println();
		print(obj.removeNthFromEnd(create(2), 2));
	}

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

	public static void print(ListNode node) {
		if (node == null) {
			System.out.print("nil");
		} else {
			System.out.print(node.val + "->");
			print(node.next);
		}
	}

}
