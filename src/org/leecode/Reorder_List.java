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
    private ListNode mergeList(ListNode l1, ListNode l2){
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
    private ListNode reverseList(ListNode head){
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
    private ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){//slow is the middle node
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
  //find rear part of list
    //reverse rear part
    //merge front and rear part
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode mid = findMiddleNode(head);
        ListNode newHead = mid.next;
        mid.next = null;
        newHead = reverseNode(newHead);
        head = mergeLink(head, newHead);
    }
    //Find middle node in a linked list
    private ListNode findMiddleNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //reverse linked list
    private ListNode reverseNode(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while(head.next != null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return pre.next;
    }
    
    private ListNode mergeLink(ListNode n1, ListNode n2){
        ListNode pre = n1;
        while(n1 != null && n2 != null){
            ListNode tem1 = n1.next;
            ListNode tem2 = n2.next;
            n1.next = n2;
            n2.next = tem1;
            n2 = tem2;
            n1 = tem1;
        }
        while(n2 != null)
            n1.next = n2;
        return pre.next;
    }
}
