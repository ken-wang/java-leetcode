package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.ListNode;

public class MergeKthSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0) {
			return null;
		} else if (lists.length == 1) {
			return lists[0];
		}

		List<ListNode> nodes = new ArrayList<>();
		for (int i = 0; i < lists.length; i += 2) {
			ListNode node = null;
			if (i + 1 < lists.length) {
				node = mergeTwoLists(lists[i], lists[i + 1]);
			} else {
				node = mergeTwoLists(lists[i], null);
			}
			nodes.add(node);
		}
		return mergeKLists(nodes.toArray(new ListNode[nodes.size()]));

	}

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
