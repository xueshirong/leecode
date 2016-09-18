package org.leecode.Test;

import org.junit.Test;
import org.leecode.Sort_List;
import org.leecode.Common.ListNode;

public class Sort_ListTest {
	Sort_List p = new Sort_List();
	@Test
	public void testSortList() {
		ListNode head = new ListNode(2);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		head.next = a;
		a.next = b;
		p.sortList(head);
	}

}
