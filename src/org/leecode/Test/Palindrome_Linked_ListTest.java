package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Palindrome_Linked_List;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Palindrome_Linked_ListTest {
	Palindrome_Linked_List pll = new Palindrome_Linked_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsPalindrome() {
		ListNode A = new ListNode(1);
		ListNode B = new ListNode(2);
		A.next = B;
		ListNode head = Utility.getTestListNode();
		assertTrue(pll.isPalindrome2(A));
	}

}
