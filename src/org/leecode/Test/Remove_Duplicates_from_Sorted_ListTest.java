package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Remove_Duplicates_from_Sorted_List;
import org.leecode.Common.ListNode;
import org.leecode.Common.Utility;

public class Remove_Duplicates_from_Sorted_ListTest {
	Remove_Duplicates_from_Sorted_List rdfsl = new Remove_Duplicates_from_Sorted_List();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDeleteDuplicates() {
		ListNode head = Utility.getTestDuplicatesListNode();
		/*while(head != null){
			System.out.println(head.val);
			head = head.next;
		}*/
		ListNode newHead = rdfsl.deleteDuplicates(head);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
