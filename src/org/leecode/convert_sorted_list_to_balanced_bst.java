package org.leecode;

import java.util.ArrayList;
import java.util.List;

import org.leecode.Common.ListNode;

public class convert_sorted_list_to_balanced_bst {
	private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
    //From Jiu Zhang
    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
    //--------------------------------------------------------------------------------------
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    //from Internet. Find mid node every recursion
    public TreeNode sortedListToBST2(ListNode head) {  
        //corner case
        if (head == null)
            return null;
            
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (pre != null)
            pre.next = null;
        else
            head = null;
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
    //--------------------------------------------------------
    //By myself. Using list to store value, then build tree
    public TreeNode sortedListToBST3(ListNode head) {
        if (head == null)
            return null;
        List<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(head.val);
            head= head.next;
        }
        TreeNode root = helper3(list, 0, list.size() - 1);
        return root;
    }
    private TreeNode helper3(List<Integer> list, int start, int end){
        if (start > end)
            return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper3(list, start, mid - 1);
        root.right = helper3(list, mid + 1, end);
        return root;
    } 
}
