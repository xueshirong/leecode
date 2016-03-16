package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Insertion_Sort_List;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Insertion_Sort_ListTest {
	Insertion_Sort_List isl = new Insertion_Sort_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsertionSortList() {		
		ListNode head = Utility.getTestListNode();
		isl.insertionSortList(head);
	}

}
