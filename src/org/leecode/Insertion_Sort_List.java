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
	
	//From Jiu Zhang
    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null){
            ListNode node = dummy;
            while(node.next != null && node.next.val < head.val)
                node = node.next;
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
