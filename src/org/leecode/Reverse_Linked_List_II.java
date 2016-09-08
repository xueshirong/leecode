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
        ListNode temp = nodeM.next;
        for (int i = 0; i < n-m; i++){
        	nodeM.next = temp.next;
        	temp.next = pre.next;
        	pre.next = temp;
        	temp = nodeM.next;
        }
        return dumpHead.next;
    }
	public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        
        int index = 1;
        while(pre != null && index < m){
            pre = pre.next;
            index++;
        }
        ListNode nodeM = pre.next;
        for (int i = m; i < n; i++){
            ListNode temp = nodeM.next;
            nodeM.next = temp.next;
            temp.next = pre.next;
            pre.next =temp;
        }
        
        return dump.next;
    }
}
