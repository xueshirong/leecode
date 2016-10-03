package org.leecode;

import org.leecode.Common.ListNode;

public class Remove_Duplicates_from_Sorted_List {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre =  null;
        ListNode cur = head;
        while(cur != null){
            if (cur != null && pre != null && cur.val == pre.val){
                ListNode temp = cur.next;
                pre.next = cur.next;
                cur = temp;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        
        return head;
    }
	
	public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null){
            if (head.val != head.next.val)
                head = head.next;
            else{//del head.next
                head.next = head.next.next;
            }
        }
        return dummy.next;
    }
}
