package org.leecode;

import org.leecode.Common.ListNode;

public class Insertion_Sort_List {
	public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        ListNode p = newHead;
        while(head != null) {
            cur = head;
            p = newHead;
            head = head.next;
            while(p.next != null && p.next.val<=cur.val) 
                p = p.next;
            cur.next = p.next;
            p.next = cur;
        }
      
        return newHead.next;
    }
}
