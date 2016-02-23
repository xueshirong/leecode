package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Linked_List_Cycle;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Linked_List_CycleTest {
	Linked_List_Cycle llc = new Linked_List_Cycle();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHasCycle() {
		ListNode head = Utility.getTestListCycleNode();
		assertTrue(llc.hasCycle(head));		
	}

}
