package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Add_Two_Numbers;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Add_Two_NumbersTest {
	Add_Two_Numbers atn = new Add_Two_Numbers();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddTwoNumbers() {
		ListNode l1 = Utility.getTestListNode();
		ListNode l2 = Utility.getTestListNode();
		atn.addTwoNumbers(l1, l2);
	}

}
