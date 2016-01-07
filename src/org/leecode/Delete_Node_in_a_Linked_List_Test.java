package org.leecode;
import org.junit.Before;
import org.junit.Test;

public class Delete_Node_in_a_Linked_List_Test {
	Delete_Node_in_a_Linked_List dnl = new Delete_Node_in_a_Linked_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Delete_Node_in_a_Linked_List_ListNode node0 = new Delete_Node_in_a_Linked_List_ListNode(0);
		Delete_Node_in_a_Linked_List_ListNode node1 = new Delete_Node_in_a_Linked_List_ListNode(1);
		Delete_Node_in_a_Linked_List_ListNode node2 = new Delete_Node_in_a_Linked_List_ListNode(2);
		Delete_Node_in_a_Linked_List_ListNode node3 = new Delete_Node_in_a_Linked_List_ListNode(3);
		
		node0.next = node1;
		//node2.next = node3;
		//node3.next = node4;
		
		dnl.deleteNode(node0);
	}

}
