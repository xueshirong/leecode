package org.leecode;

import java.util.ArrayList;

public class Binary_Tree_Postorder_Traversal {
	/**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //corner case
        if (root == null)
            return res;
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, ArrayList<Integer> res){
        if (root == null)
            return;
        if (root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}
