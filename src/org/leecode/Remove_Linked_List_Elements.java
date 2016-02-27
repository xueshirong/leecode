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
}
