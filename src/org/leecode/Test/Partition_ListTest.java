package org.leecode.Test;

import org.junit.Test;
import org.leecode.Partition_List;
import org.leecode.Common.ListNode;

public class Partition_ListTest {
	Partition_List p = new Partition_List();
	@Test
	public void testPartition() {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(4);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(2);
		ListNode head4 = new ListNode(5);
		ListNode head5 = new ListNode(2);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		
		p.partition(head, 3);
	}

}
