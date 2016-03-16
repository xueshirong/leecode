package org.leecode;

import org.leecode.Common.ListNode;

public class Reverse_Nodes_in_kGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode tail = newHead;
        ListNode start = pre.next;
        while (true){
            int count = 0;
            while(count < k && tail != null){//find the kth node
                tail = tail.next;
                count++;
                if (tail == null)
                    return newHead.next;
            }
            if (count != k)
            	return newHead.next;
            for (int i = 0; i < k-1; i++){//reverse the k nodes
                ListNode then = start.next;
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
            }
            tail = start;
            pre = start;
            start = start.next;
        }
    }
}
