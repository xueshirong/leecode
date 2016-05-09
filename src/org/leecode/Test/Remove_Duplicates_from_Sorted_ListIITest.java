package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Remove_Duplicates_from_Sorted_ListII;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Remove_Duplicates_from_Sorted_ListIITest {
	Remove_Duplicates_from_Sorted_ListII rdfsl = new Remove_Duplicates_from_Sorted_ListII();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDeleteDuplicates() {
		ListNode head = Utility.getTestListNode();
		rdfsl.deleteDuplicates(head);
	}

}
