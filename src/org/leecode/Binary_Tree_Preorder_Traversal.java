package org.leecode;

import java.util.ArrayList;
import java.util.Stack;

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
    //From Jiu Zhang
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root == null)
            return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }
}
