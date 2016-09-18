package org.leecode;

import org.leecode.Common.ListNode;

public class Sort_List {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return mergeSort(head);
    }
     private ListNode mergeSort(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode midNode = findMidNode(head);//get middle node]
        ListNode newHead = midNode.next;//new head of right list
        midNode.next = null;
        ListNode left = mergeSort(head);//recursive mergeSort left part
        ListNode right = mergeSort(newHead);//recursive mergeSort right part
        return merge2Sort(left, right);//merge left and right list
    }
    //get middle node of list
    private ListNode findMidNode(ListNode head){
        if (head == null)
            return head;
        ListNode fast = head.next;//watch here
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //merge 2 sorted list
    private ListNode merge2Sort(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(h1 != null && h2 != null){
            if (h1.val < h2.val){
                pre.next = h1;
                h1 = h1.next;
            }else{
                pre.next = h2;
                h2 = h2.next;
            }
            pre = pre.next;
        }
        if (h1 != null)
            pre.next = h1;
        if (h2 != null)
            pre.next = h2;
        return dummy.next;
    }
}
