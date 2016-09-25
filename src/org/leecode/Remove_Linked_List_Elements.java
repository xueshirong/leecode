package org.leecode;

import org.leecode.Common.ListNode;

public class Remove_Linked_List_Elements {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode newHead = pre;
        while(head != null){
            if (head.val == val){
                pre.next = head.next;
                head = pre.next;
            }else{
                head = head.next;
                pre = pre.next;
            }
        }
        return newHead.next;
    }
	
	public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null){
            if (head.val != val){
                head = head.next;
                pre = pre.next;
            }else{//remove head
                pre.next = head.next;
                head = pre.next;
            }
        }
        return dummy.next;
    }
}
