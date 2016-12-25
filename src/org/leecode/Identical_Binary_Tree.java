package org.leecode;

public class Identical_Binary_Tree {
	/**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
	//same with the leetcode "Same Tree"
    public boolean isIdentical(TreeNode a, TreeNode b) {
    	//corner case
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        
        boolean isroot = (a.val == b.val);//check root
        boolean isleft = isIdentical(a.left, b.left);//check left node
        boolean isright = isIdentical(a.right, b.right);//check right node
        
        return (isroot && isleft && isright);//only if all condition are true, return true;
    }
}
