package org.leecode;

import org.leecode.Common.ListNode;

public class Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode temp = head;
		while(head != null){
			temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}	
		
		return pre;
	}
	public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
	
	 public ListNode reverseList3(ListNode head) {//recursively
	        if (head == null || head.next == null)
	            return head;
	        ListNode nextNode = head.next;
	        ListNode newHead = reverseList(nextNode);
	        nextNode.next = head;
	        head.next = null;
	        
	        return newHead;
	    }
}
