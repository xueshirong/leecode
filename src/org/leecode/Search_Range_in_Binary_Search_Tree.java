package org.leecode;

import java.util.ArrayList;

public class Search_Range_in_Binary_Search_Tree {
	//Thought: use inorder traversal logic
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    ArrayList<Integer> res = new  ArrayList<Integer>();
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        //corner case
        if (root == null || k1 > k2)
            return res;
        helper(root, k1, k2);
        return res;
    }
    private void helper(TreeNode root, int k1, int k2){
        if (root == null)
            return;
        helper(root.left, k1, k2);
        if (root.val >= k1 && root.val <= k2)
            res.add(root.val);
        helper(root.right, k1, k2);
    }
}
