package org.leecode;

public class Path_Sum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null){
            return true;
        }
        
        if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)){
            return true;
        }
        
        return false;
    }
	//From Jiu Zhang
	//Definition of leaf: node that has no children.
	//That confused me for a while also.
	public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum (root.left, sum - root.val)
            || hasPathSum(root.right, sum - root.val);
    }
}
