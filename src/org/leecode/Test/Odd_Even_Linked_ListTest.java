package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.ListNode;
import org.leecode.Odd_Even_Linked_List;
import org.leecode.Common.Utility;

public class Odd_Even_Linked_ListTest {
	Odd_Even_Linked_List oell = new Odd_Even_Linked_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOddEvenList() {
		ListNode head = Utility.getTestListNode();
		ListNode newhead =  oell.oddEvenList(head);
		while(newhead != null){
			System.out.println(newhead.val);
			newhead = newhead.next;
		}
	}
	
	@Test
	public void testOddEvenList1() {
		ListNode head = Utility.getTestListNode();
		ListNode newhead =  oell.oddEvenList1(head);
		while(newhead != null){
			System.out.println(newhead.val);
			newhead = newhead.next;
		}
	}

}
