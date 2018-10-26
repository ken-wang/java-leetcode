package leetcode;

import leetcode.model.ListNode;

public class ReverseNodesInKthGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = k;
        while (count > 0 && cur != null) {
            count--;
            cur = cur.next;
        }
        if (count == 0) {
            cur = reverseKGroup(cur, k);
            for (int i = 0; i < k; i++) {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }
}
