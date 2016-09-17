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
	//From Jiu Zhang
	public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (n <= 0)
            return null;
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode slow = dump;//use 2 fast/slow point
        ListNode fast = dump;
        for (int i = 0; i < n; i++){//the distance between 2 points is n
            if (fast == null)
                return null;
            fast = fast.next;
        }
        while(fast.next != null){//fast is the last non-null node
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;//del nth node
        return dump.next;
    }
}
