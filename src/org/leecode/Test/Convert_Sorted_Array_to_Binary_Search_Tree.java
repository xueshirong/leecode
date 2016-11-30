package org.leecode.Test;

import org.leecode.TreeNode;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	//Given an array where elements are sorted in ascending order, 
	//convert it to a height balanced BST.
	//From Jiu Zhang
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        
        TreeNode root = helper(nums, 0, nums.length -1);
        return root;
    }
    private TreeNode helper(int[] nums, int start, int end){
        if (start > end)
            return null;
        
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);//end = mid - 1
        root.right = helper(nums, mid + 1, end);//start = mid + 1
        return root;
    }
}
