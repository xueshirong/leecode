package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Merge_Two_Sorted_Lists;
import org.leecode.Common.ListNode;

public class Merge_Two_Sorted_ListsTest {
	Merge_Two_Sorted_Lists mtsl = new Merge_Two_Sorted_Lists();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMergeTwoLists() {
		ListNode A = new ListNode(1);
		ListNode B = new ListNode(5);
		A.next = B;
		/*ListNode C = new ListNode(3);
		A.next = B;
		B.next = C;*/
		
		ListNode a = new ListNode(2);
		//ListNode b = new ListNode(2);
		//ListNode c = new ListNode(2);
		//a.next = b;
		//b.next = c;
		
		mtsl.mergeTwoLists(A, a);
	}

}
