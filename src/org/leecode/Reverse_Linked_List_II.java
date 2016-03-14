package org.leecode;

import org.leecode.Common.ListNode;

public class Reverse_Linked_List_II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n)
            return head;
        ListNode dumpHead = new ListNode(0);
        dumpHead.next = head;
        ListNode pre = dumpHead;
        
        for (int i = 0; i< m-1; i++){
            pre = pre.next;
        }
        ListNode nodeM = pre.next;
        ListNode next = nodeM.next;
        for (int i = 0; i < n-m; i++){
        	nodeM.next = next.next;
        	next.next = pre.next;
        	pre.next = next;
        	next = nodeM.next;
        }
        return dumpHead.next;
    }
    
}
