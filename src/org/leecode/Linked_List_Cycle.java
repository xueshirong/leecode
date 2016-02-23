package org.leecode;

import org.leecode.Common.ListNode;

public class Linked_List_Cycle {
	public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
           
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow))
                return true;
        }
        return false;
    }
}
