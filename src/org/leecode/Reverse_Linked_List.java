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
}
