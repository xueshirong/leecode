package org.leecode;

import org.leecode.Common.ListNode;

public class Rotate_List {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        Integer len = 1;
        ListNode cur = head;
        while(cur.next != null){//get the length of list
            len++;
            cur = cur.next;
        }
        if (k%len == 0)//if k is Integer time of len, that means no need to roate the list
            return head;
        k = k%len;
        cur.next = head;//make a cycle list
        ListNode pre = cur;
        Integer index = 1;
        while(index <= len-k){//loop head to the (index - k) node, this is the new head postion
            head = head.next;
            pre = pre.next;
            index++;
        }
        pre.next = null;
        return head;
    }
}
