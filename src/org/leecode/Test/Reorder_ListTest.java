package org.leecode.Test;

import org.junit.Test;
import org.leecode.Reorder_List;
import org.leecode.Common.ListNode;

public class Reorder_ListTest {
	Reorder_List p = new Reorder_List();
	@Test
	public void testReorderList2() {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		p.reorderList3(head);
	}
}
