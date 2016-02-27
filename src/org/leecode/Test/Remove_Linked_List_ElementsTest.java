package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Remove_Linked_List_Elements;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Remove_Linked_List_ElementsTest {
	Remove_Linked_List_Elements rlle = new Remove_Linked_List_Elements();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRemoveElements() {
		ListNode head = Utility.getTestListNode();
		/*while(head != null){
			System.out.println(head.val);
			head = head.next;
		}*/
		ListNode newHead = rlle.removeElements(head, 2);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
