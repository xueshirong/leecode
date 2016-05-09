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
		rl.rotateRight(head, 2);
	}

}
