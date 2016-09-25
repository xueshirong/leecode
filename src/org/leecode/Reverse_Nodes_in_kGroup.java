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
	
	public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k < 2)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int index = 1;
        while(true){
        	ListNode temphead = head;
            for(int i = 0; i < k; i++){//check if have K node
                if (temphead == null)
                    return dummy.next;
                temphead = temphead.next;
            } 
            index = 1;
            while(index < k){//reverse k node
            	ListNode temp = head.next;
            	head.next = temp.next;
            	temp.next = pre.next;
            	pre.next = temp;            
                index++;                
            }
            pre = head;
            head = pre.next;  
        }        
        //return dummy.next;
    }
}
