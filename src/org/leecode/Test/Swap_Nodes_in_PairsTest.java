package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Swap_Nodes_in_Pairs;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Swap_Nodes_in_PairsTest {
	Swap_Nodes_in_Pairs snip = new Swap_Nodes_in_Pairs();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSwapPairs() {
		ListNode head = Utility.getTestListNode();
		/*while(head != null){
			System.out.println(head.val);
			head = head.next;
		}*/
		ListNode newHead = snip.swapPairs(head);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
