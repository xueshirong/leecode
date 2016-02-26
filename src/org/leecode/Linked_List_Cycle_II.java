package org.leecode;

import org.leecode.Common.ListNode;

public class Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        boolean haveCycle = false;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)){
                haveCycle = true;
                break;
            }
        }
        if (haveCycle){
            while(head != null){
                if (head.equals(slow)){
                    return slow;
                }
                head = head.next;
                slow = slow.next;
            }
        }
        return null;
    }
}
