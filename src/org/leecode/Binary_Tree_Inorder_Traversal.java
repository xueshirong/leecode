package org.leecode;

import java.util.ArrayList;

public class Binary_Tree_Inorder_Traversal {
	/**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    ArrayList<Integer> res = new ArrayList<Integer>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return res;
        if (root.left == null && root.right == null){
            res.add(root.val);
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
