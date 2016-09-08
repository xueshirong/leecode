package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Reverse_Linked_List_II;
import org.leecode.Common.ListNode;

public class Reverse_Linked_List_IITest {
	Reverse_Linked_List_II rllii = new Reverse_Linked_List_II();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReverseBetween() {
		//ListNode head = Utility.getTestListNode();
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		head.next = head1;
		head1.next = head2;
		rllii.reverseBetween(head, 1, 3);
	}

}
