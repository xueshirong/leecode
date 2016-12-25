package org.leecode.Test;

import org.leecode.TreeNode;

public class Tweaked_Identical_Binary_Tree {
	/**
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
	//Check two given binary trees are identical or not. Assuming any number of tweaks are allowed. 
	//A tweak is defined as a swap of the children of one node in the tree.
	//Note: There is no two nodes with the same value in the tree
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        //corner case
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;
        
        //After tweaking, check left == right
        boolean isTleft = isTweakedIdentical(a.left, b.right);
        boolean isTright = isTweakedIdentical(a.right, b.left);
        
        //No tweak, check left == left, right == right
        boolean isIdenticalLeft = isTweakedIdentical(a.left, b.left);
        boolean isIdenticalRight = isTweakedIdentical(a.right, b.right);
        
        return ((isTleft && isTright) || (isIdenticalLeft && isIdenticalRight));
    }
}
