package org.leecode;

import java.util.List;
import java.util.ArrayList;

public class Binary_Tree_Path_Sum {
	//Given a binary tree, find all paths that sum of the nodes in the path equals 
	//to a given number target.
	//A valid path is from root node to any of the leaf nodes.
	/**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
	//From Jiu Zhang
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
    	// Algorithm: Traverse
        // Use recursion to traverse the tree in preorder, pass with a parameter
        // `sum` as the sum of each node from root to current node.
        // Put the whole path into result if the leaf has a sum equal to target.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        int sum = root.val;
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(res, path, root, sum, target);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> path, 
                        TreeNode root, int sum, int target){
        //meet leaf
        if (root.left == null && root.right == null){
            if (sum == target){
                res.add(new ArrayList<Integer>(path));
                return;
            }
        }
        //meet left leaf
        if (root.left != null){
            path.add(root.left.val);
            helper(res, path, root.left, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        
        //meet right leaf
        if (root.right != null){
            path.add(root.right.val);
            helper(res, path, root.right, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}
