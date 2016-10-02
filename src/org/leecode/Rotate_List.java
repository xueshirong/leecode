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
	
	//From Jiu Zhang
	public ListNode rotateRight2(ListNode head, int k) {
		if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        int length = 0;
        while (fast.next != null){//get the length of list
            fast = fast.next;
            length++;
        }
        k = k % length;// if k > length, then recalculate k
        if (k == 0)
            return dummy.next;
        fast = dummy;
        while (k > 0){// move fast to kth node
            fast = fast.next;
            k--;
        }
        
        while(fast != null && fast.next != null){//move slow to the kth from tail
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = pre.next;
        pre.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
