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
		ListNode head = Utility.getTestListNode();
		assertTrue(pll.isPalindrome(head));
	}

}
