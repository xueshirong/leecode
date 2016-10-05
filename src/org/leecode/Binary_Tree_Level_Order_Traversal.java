package org.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, TreeNode root, int height){
        if (root == null)
            return;
        if (height >= res.size()){
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        helper(res, root.left, height+1);
        helper(res, root.right, height+1);
    }
    
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        helper2(res, root, 0);
        return res;
    }
    private void helper2(List<List<Integer>> res, TreeNode root, int height){
        if (root == null)
            return;
        if (res.size() <= height)//key point "<="
            res.add(new ArrayList<Integer>());
        res.get(height).add(root.val);
        helper2(res, root.left, height + 1);
        helper2(res, root.right, height + 1);
    }
}
