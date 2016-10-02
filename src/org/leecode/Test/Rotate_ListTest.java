package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Rotate_List;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Rotate_ListTest {
	Rotate_List rl = new Rotate_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRotateRight() {
		ListNode head = Utility.getTestListNode();
		head = new ListNode(1);
		ListNode a = new ListNode(2);
		head.next = a;
		rl.rotateRight2(head, 1);
	}

}
