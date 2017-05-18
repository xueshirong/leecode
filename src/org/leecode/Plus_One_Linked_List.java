package org.leecode;
import org.leecode.Common.ListNode;
public class Plus_One_Linked_List {
	public ListNode plusOne(ListNode head) {
        if (head == null)
            return new ListNode(1);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int carry = helper(head);
        if (carry == 1){
            ListNode node = new ListNode(1);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
    
    int helper(ListNode head){
    	if (head == null)
            return 1;
        int carry = helper(head.next);
        if (carry == 0)
            return 0;
        int sum = (head.val + carry) % 10;
        carry = (head.val + carry) / 10;
        head.val = sum;
        
        return carry;
    }
}
