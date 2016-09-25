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
	//By self
	public ListNode swapPairs2(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while(head != null && head.next != null){//begin swap next and next.next
            ListNode temp = head.next.next;
            head.next.next = pre.next;
            pre.next = head.next;
            head.next = temp;
            pre = pre.next.next;
            head = pre.next;
        }
        return dummy.next;
    }
	
	//From Jiu Zhang
    public ListNode swapPairs3(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null){
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }
        return dummy.next;
    }
}
