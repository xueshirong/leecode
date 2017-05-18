package org.leecode.Test;

import org.junit.Test;
import org.leecode.Plus_One_Linked_List;
import org.leecode.Common.ListNode;

public class Plus_One_Linked_ListTest {
	Plus_One_Linked_List p = new Plus_One_Linked_List();
	@Test
	public void testPlusOne() {
		ListNode head = new ListNode(9);
		/*ListNode h1 = new ListNode(2);
		ListNode h2 = new ListNode(3);
		head.next = h1;
		h1.next = h2;*/
		p.plusOne(head);
	}

}
