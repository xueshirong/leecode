package org.leecode;

public class Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        boolean con1 = (left.val == right .val);
        boolean con2 = helper(left.left, right.right);
        boolean con3 = helper(left.right, right.left);
        return con1 && con2 && con3;
    }
}
