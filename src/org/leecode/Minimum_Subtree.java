package org.leecode;

//Jiu Zhang - http://www.lintcode.com/en/problem/minimum-subtree/
//Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
public class Minimum_Subtree {
	int sum = Integer.MAX_VALUE;
    TreeNode subtree = null;
    
    /*
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }
    private int helper(TreeNode root){
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int result = left + right + root.val;
        
        if (subtree == null || result < sum){
            subtree = root;
            sum = result;
        }
        return result;
    }
}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
