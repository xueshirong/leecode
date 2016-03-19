package org.leecode;

import org.leecode.Common.ListNode;

public class Reorder_List {
	public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode midNode = findMidNode(head);
        ListNode rearHead = midNode.next;
        midNode.next = null;
        rearHead = reverseList(rearHead);
        head = mergeList(head, rearHead);
    }
    //merge l2 to l1
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        pre.next = l1;
        ListNode temp = null;
        while(l2 != null){
            temp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l2 = temp;
            l1 = l1.next.next;
        }
        return pre.next;
    }
    //reverse a list
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    //find middle node in a list
    public ListNode findMidNode(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){//slow is the middle node
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null && fast.next.next == null) //fast is the tail node
            fast = fast.next;
        return slow;
    }
}
