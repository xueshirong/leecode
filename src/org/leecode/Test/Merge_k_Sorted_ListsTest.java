package org.leecode.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.leecode.Merge_k_Sorted_Lists;
import org.leecode.Common.ListNode;

public class Merge_k_Sorted_ListsTest {
	Merge_k_Sorted_Lists p = new Merge_k_Sorted_Lists();
	@Test
	public void testMergeKLists() {
		ListNode a = null;
		ListNode b = new ListNode(1);
		ListNode[] lists = new ListNode[]{a,b};
		p.mergeKLists(lists);
	}

}
