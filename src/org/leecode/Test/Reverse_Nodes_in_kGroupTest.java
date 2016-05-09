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
		ListNode head = Utility.getTestListNode();
		rdk.reverseKGroup(head, 2);
	}

}
