package org.leecode.Common;

import java.util.Scanner;

public class Utility {
	public static ListNode getTestListNode(){
		ListNode A = new ListNode(2);
		ListNode B = new ListNode(5);
		ListNode C = new ListNode(4);
		ListNode D = new ListNode(6);
		ListNode E = new ListNode(1);
		ListNode F = new ListNode(3);
		/*ListNode G = new ListNode(2);
		ListNode H = new ListNode(1);*/
		
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		E.next = F;
		/*F.next = G;
		G.next = H;*/
		return A;
	}
	
	//Linked List Cycle
	public static ListNode getTestListCycleNode(){
		ListNode A = new ListNode(1);
		ListNode B = new ListNode(2);
		ListNode C = new ListNode(3);
		ListNode D = new ListNode(4);
		ListNode E = new ListNode(5);
		ListNode F = new ListNode(6);
		ListNode G = new ListNode(7);
		ListNode H = new ListNode(8);
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		E.next = F;
		F.next = G;
		G.next = H;
		H.next = F;
		return A;
	}

	public static ListNode getTestDuplicatesListNode(){
		ListNode A = new ListNode(1);
		ListNode B = new ListNode(1);
		ListNode C = new ListNode(2);
		ListNode D = new ListNode(4);
		/*ListNode E = new ListNode(5);
		ListNode F = new ListNode(6);
		ListNode G = new ListNode(7);
		ListNode H = new ListNode(8);*/
		
		A.next = B;
		B.next = C;
		C.next = D;
		/*D.next = E;
		E.next = F;
		F.next = G;
		G.next = H;*/
		return A;
	}
}
