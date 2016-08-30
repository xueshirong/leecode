package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Add_Two_Numbers;
import org.leecode.Common.ListNode;

public class Add_Two_NumbersTest {
	Add_Two_Numbers atn = new Add_Two_Numbers();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddTwoNumbers() {
		ListNode A = new ListNode(0);
		ListNode B = new ListNode(7);
		ListNode C = new ListNode(3);
		//A.next = B;
		//B.next = C;
		
		ListNode D = new ListNode(7);
		ListNode E = new ListNode(3);
		ListNode F = new ListNode(4);
		D.next = E;
		//E.next = F;
		
		ListNode l1 = A;
		ListNode l2 = D;
		atn.addTwoNumbers(l1, l2);
		
		atn.addTwoNumbers2(l1, l2);
	}

}
