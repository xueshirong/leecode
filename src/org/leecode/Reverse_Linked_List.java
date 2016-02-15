package org.leecode;

public class Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        while(currNode.next != null){
        	ListNode tempNode = currNode;
        	currNode = currNode.next;
            currNode.next = tempNode;
        }
        return currNode;
    }
}
