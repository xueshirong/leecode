package org.leecode;

import org.leecode.Common.ListNode;

public class Merge_k_Sorted_Lists {
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeHelper(lists, 0, lists.length-1);
    }
    private ListNode mergeHelper(ListNode[] lists, int start, int end){
        if (start == end)
            return lists[start];
        int mid = start + (end - start)/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid+1, end);
        return merge2list(left, right);
    }
    private ListNode merge2list(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1 != null)
            head.next = l1;
        if(l2 != null)
            head.next = l2;
        return dummy.next;
    }
}
