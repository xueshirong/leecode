package org.leecode;

import org.leecode.Common.ListNode;

public class Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode empty = new ListNode(0);
        ListNode head = empty;
        Integer temp = 0;
        Integer value = 0;
        while (l1 != null || l2 != null){
            value = 0;
            if (l1 != null){
                value = value + l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                value = value + l2.val;
                l2 = l2.next;
            }
                
            value = value + temp;
            temp = value/10;
            value = value%10;
            
            head.next = new ListNode(value);
            head = head.next;
        }
        if (temp > 0){
            ListNode tail = new ListNode(temp);
            head.next = tail;
        }
        return empty.next;
    }
}
