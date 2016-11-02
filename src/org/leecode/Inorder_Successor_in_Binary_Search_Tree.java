package org.leecode;

import java.util.ArrayList;

public class Inorder_Successor_in_Binary_Search_Tree {
	//Given a binary search tree (See Definition) and a node in it, 
	//find the in-order successor of that node in the BST.
	//If the given node has no in-order successor in the tree, return null.
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        helper(res, root);
        
        int index = -1;
        for(int i = 0; i < res.size(); i++){
            if (res.get(i).val == p.val){
                index = i + 1;
                break;
            }
        }
        if (index <= 0 || index == res.size())
            return null;
        return res.get(index);
    }
    private void helper(ArrayList<TreeNode> res, TreeNode root){
        if (root == null)
            return;
        helper(res, root.left);
        res.add(root);
        helper(res, root.right);
    }
}
