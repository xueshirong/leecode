package org.leecode;

import org.leecode.Common.ListNode;

public class Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val || l1.val == l2.val){//add l1 to temp
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }else{//add l2 to temp
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
            temp.next = null;
        }
        
        if (l1 != null){
            temp.next = l1;
        }
        else{
            temp.next = l2;
        }
        
        return head.next;
	}
}
