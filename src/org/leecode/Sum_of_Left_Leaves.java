package org.leecode;

public class Sum_of_Left_Leaves {
	//use dfs to traverse tree, if the node is leaf and left, then add val to res
	int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return res;
    }
    private void helper(TreeNode root, boolean isleft){
        if(root == null)
            return;
        if (root.left == null && root.right == null && isleft)
            res += root.val;
        helper(root.left, true);
        helper(root.right, false);
    }
}
