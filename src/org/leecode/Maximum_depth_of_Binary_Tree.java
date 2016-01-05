package org.leecode;

//import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Maximum_depth_of_Binary_Tree {
	
	public int maxDepth(TreeNode root) {
        if (root == null)
        	return 0;
        int numL = 1 + maxDepth(root.left);
        int numR = 1 + maxDepth(root.right);
        if (numL > numR)
        	return numL;
        
        return numR;
    }
}
