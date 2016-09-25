package org.leecode;

import org.leecode.Common.ListNode;

public class Delete_Node_in_a_Linked_List {
	public void deleteNode(Delete_Node_in_a_Linked_List_ListNode node) {
		//should we use the loop?maybe just set next node to current node.
        node.val = node.next.val;
        node.next = node.next.next;	
    }
	
	//From Jiu Zhang
	public void deleteNode2(ListNode node) {
        if (node != null && node.next != null){
            node.val = node.next.val;//copy next node'value to current node
            node.next = node.next.next;//delete the next node
        }
    }
}
