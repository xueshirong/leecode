package org.leecode;

public class Delete_Node_in_a_Linked_List {
	public void deleteNode(Delete_Node_in_a_Linked_List_ListNode node) {
        while (node.next != null){//should we use the loop?maybe just set next node to current node.
            node = node.next;
        }
    }
}
