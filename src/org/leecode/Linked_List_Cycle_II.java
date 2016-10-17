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
	
	public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head, slow = head;
        boolean circle = false;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                slow = head;
                circle = true;
                break;
            }
        }
        if (!circle)
            return null;
        
        while (circle && fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
