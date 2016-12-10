package org.leecode.Test;

import org.junit.Test;
import org.leecode.Rehashing;
import org.leecode.Common.ListNode;

public class RehashingTest {
	Rehashing p = new Rehashing();
	@Test
	public void testRehashing() {
		ListNode node = new ListNode(21);
		ListNode node1 = new ListNode(9);
		node.next = node1;
		ListNode node2 = new ListNode(14);
		ListNode[] hashTable = new ListNode[]{null, node, node2, null};
		p.rehashing(hashTable);
	}

}
