package org.leecode;

import java.util.List;

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
    //------------------------------
    //Merge k sorted linked lists and return it as one sorted list.
    //Analyze and describe its complexity.
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    //From Jiu Zhang
    public ListNode mergeKLists2(List<ListNode> lists) {  
        // corner case
        if (lists == null || lists.size() == 0)
            return null;
        ListNode head = helper(lists, 0, lists.size() - 1);
        return head;
    }
    private ListNode helper(List<ListNode> lists, int start, int end){
        if (start == end)
            return lists.get(start);
        int mid = start + (end - start)/2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        ListNode node = merger2listnode(left, right);
        return node;
    }
    private ListNode merger2listnode(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                pre.next = left;
                left = left.next;
            }else{
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;//remember to move to next point
        }
        if (left != null)
            pre.next = left;
        else if (right != null)
            pre.next = right;
        return dummy.next;
    }
}
