package org.leecode.Test;

import org.junit.Test;
import org.leecode.convert_sorted_list_to_balanced_bst;
import org.leecode.Common.ListNode;

public class convert_sorted_list_to_balanced_bstTest {
	convert_sorted_list_to_balanced_bst p = new convert_sorted_list_to_balanced_bst();
	@Test
	public void testSortedListToBST() {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(4);
		ListNode head4 = new ListNode(5);
		ListNode head5 = new ListNode(6);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = null;
		
		p.sortedListToBST(head);
	}

}
