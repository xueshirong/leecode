package org.leecode;

public class Delete_Node_in_a_Linked_List {
	public void deleteNode(Delete_Node_in_a_Linked_List_ListNode node) {
		//should we use the loop?maybe just set next node to current node.
        node.val = node.next.val;
        node.next = node.next.next;	
    }
}
