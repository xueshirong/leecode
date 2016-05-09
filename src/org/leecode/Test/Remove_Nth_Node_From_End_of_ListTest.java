package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Remove_Nth_Node_From_End_of_List;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Remove_Nth_Node_From_End_of_ListTest {
	Remove_Nth_Node_From_End_of_List rnnfeol = new Remove_Nth_Node_From_End_of_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRemoveNthFromEnd() {
		ListNode head = Utility.getTestListNode();
		/*while(head != null){
			System.out.println(head.val);
			head = head.next;
		}*/
		ListNode newHead = rnnfeol.removeNthFromEnd(head,1);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}
