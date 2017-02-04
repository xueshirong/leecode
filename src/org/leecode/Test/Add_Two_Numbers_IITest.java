package org.leecode.Test;

import org.junit.Test;
import org.leecode.Add_Two_Numbers_II;
import org.leecode.Common.ListNode;

public class Add_Two_Numbers_IITest {
	Add_Two_Numbers_II p = new Add_Two_Numbers_II();
	@Test
	public void testAddTwoNumbers2() {
		//(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
		ListNode l1 = new ListNode(7);
		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(3);
		l1.next = l10;
		l10.next = l11;
		l11.next = l12;
		
		ListNode l2 = new ListNode(5);
		ListNode l20 = new ListNode(6);
		ListNode l21 = new ListNode(4);
		l2.next = l20;
		l20.next = l21;
		p.addTwoNumbers2(l1, l2);
	}

}
