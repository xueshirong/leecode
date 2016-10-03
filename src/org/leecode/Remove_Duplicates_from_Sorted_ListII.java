package org.leecode;

import org.leecode.Common.ListNode;

public class Remove_Duplicates_from_Sorted_ListII {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
            
        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode pre = empty;
        boolean isRemoveHead = false;
        while (head != null && head.next != null){
            if (head.val != head.next.val){
                if (isRemoveHead){//remove node between pre and head
                    ListNode then = head.next;
                    pre.next = then;
                    head.next = null;
                    head = then;
                    isRemoveHead = false;
                }else{
                    head = head.next;
                    pre = pre.next;
                }
            }else{
                head = head.next;
                isRemoveHead = true;
            }
        }
        if (isRemoveHead){//remove node between pre and head
            ListNode then = head.next;
            pre.next = then;
            head.next = null;
            head = then;
        }
        return empty.next;
    }
	//From Jiu Zhang
	public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null){
            if (pre.next.val == pre.next.next.val){
                int val = pre.next.val;
                while(pre.next != null && pre.next.val == val)
                    pre.next = pre.next.next;
            }else
                pre = pre.next;
        }
        return dummy.next;
    }
}
