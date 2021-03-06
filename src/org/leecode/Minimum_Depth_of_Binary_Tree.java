package org.leecode;

public class Minimum_Depth_of_Binary_Tree {
	public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
	
	//From Jiu Zhang
	public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        return getDepth(root);        
    }
    
    private int getDepth(TreeNode node){
        if (node == null)
            return Integer.MAX_VALUE;
        if (node.left == null && node.right == null)
            return 1;
        int l = getDepth(node.left);
        int r = getDepth(node.right);
        return Math.min(l, r) + 1;
    }
}
