package org.leecode;

import org.leecode.Common.ListNode;

public class Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode newHead = head.next;
        ListNode pre = new ListNode(-1);
        while(cur != null && cur.next != null){
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return newHead;
    }
}
