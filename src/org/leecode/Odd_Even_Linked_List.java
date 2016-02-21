package org.leecode;

public class Odd_Even_Linked_List {
	public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode Ho = head;
        ListNode He = head.next;
        ListNode temp = head;
        int i = 0;
        while(head.next != null){
        	i++;
            temp = head.next;
            head.next = head.next.next;
            if (temp.next != null)
            	head = temp;
            else{
            	//head = null;
            	break;
            }
        }
        head.next = He;
        return Ho;
    }
	
	public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = even_head;
        return head;
    }
}
