package org.leecode;

import java.util.ArrayList;

public class Binary_Tree_Preorder_Traversal {
	//Given a binary tree, return the preorder traversal of its nodes' values.
	/**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, ArrayList<Integer> res){
        if (root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
