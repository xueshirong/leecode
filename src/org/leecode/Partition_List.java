package org.leecode;

import org.leecode.Common.ListNode;

public class Partition_List {
	//Given a linked list and a value x, partition it such that all nodes 
	//less than x come before nodes greater than or equal to x.
	//You should preserve the original relative order of the nodes in each of the two partitions.
	/**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        //corner case
        if (head == null)
            return head;
        ListNode leftdummy = new ListNode(0);
         ListNode left = leftdummy;
        ListNode rightdummy = new ListNode(0);
         ListNode right = rightdummy;
        while(head != null){
            if (head.val < x){
                left.next = new ListNode(head.val);
                left = left.next;
            }
            else{
                right.next = new ListNode(head.val);
                right = right.next;
            }
            head = head.next; 
        }
        left.next = rightdummy.next;
        return leftdummy.next;
    }
}
