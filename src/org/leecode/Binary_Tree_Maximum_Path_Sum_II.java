package org.leecode;

public class Binary_Tree_Maximum_Path_Sum_II {
	/**
     * @param root the root of binary tree.
     * @return an integer
     */
	//Given a binary tree, find the maximum path sum from root.
	//The path may end at any node in the tree and contain at least one node in it.
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null)
            return Integer.MIN_VALUE;//get the minimum value
            
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        
        return root.val + Math.max(0, Math.max(left, right));//if negative, get 0
    }
}
