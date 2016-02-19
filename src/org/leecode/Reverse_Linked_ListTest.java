package org.leecode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Common.Utility;

public class Reverse_Linked_ListTest {
	Reverse_Linked_List rll = new Reverse_Linked_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReverseList1() {
		ListNode head = Utility.getTestListNode();
		/*while(head != null){
			System.out.println(head.val);
			head = head.next;
		}*/
		ListNode newHead = rll.reverseList1(head);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
