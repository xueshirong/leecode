package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Reverse_Nodes_in_kGroup;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Reverse_Nodes_in_kGroupTest {
	Reverse_Nodes_in_kGroup rdk = new Reverse_Nodes_in_kGroup();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReverseKGroup() {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next =d;
		rdk.reverseKGroup2(head, 3);
	}

}
