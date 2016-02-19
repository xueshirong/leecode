package org.leecode;

public class Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
		ListNode curr = null;
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            prev = curr;
            curr = temp;
            temp = curr.next;
            curr.next = prev;
        }
        return curr;
    }
	
	public ListNode reverseList1(ListNode head) {
		
        ListNode pre = null;
        while(head != null){
        	ListNode tem = head.next;
        	head.next = pre;
        	pre = head;
        	head = tem;        	
        }
        
        
        return pre;
    }
}
