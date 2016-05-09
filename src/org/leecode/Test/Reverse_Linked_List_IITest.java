package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Reverse_Linked_List_II;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Reverse_Linked_List_IITest {
	Reverse_Linked_List_II rllii = new Reverse_Linked_List_II();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReverseBetween() {
		ListNode head = Utility.getTestListNode();
		rllii.reverseBetween(head, 1, 3);
	}

}
