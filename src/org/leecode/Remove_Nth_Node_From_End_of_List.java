package org.leecode;

import org.leecode.Common.ListNode;

public class Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
            return null;
        int N = 0;
        boolean sBegin = false;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast.next != null){
            fast = fast.next;
            if (N == n-1 || sBegin){
                pre = slow;
                slow = slow.next;
                sBegin = true;
            }
            N++;
        }
        if (pre == null){//remove the first node
            return slow.next;
        }
       
        pre.next = slow.next;
        slow = null;
        return head;
    }
}
