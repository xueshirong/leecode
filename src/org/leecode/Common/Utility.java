package org.leecode.Common;

import org.leecode.ListNode;

public class Utility {
	public static ListNode getTestListNode(){
		ListNode A = new ListNode(1);
		ListNode B = new ListNode(2);
		ListNode C = new ListNode(3);
		ListNode D = new ListNode(4);
		
		A.next = B;
		B.next = C;
		C.next = D;
		return A;
	}
}
