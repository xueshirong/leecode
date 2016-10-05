package org.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    //DFS
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
    
  //BFS
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int height = queue.size();
            for (int i = 0; i < height; i++){
                TreeNode head = queue.poll();
                list.add(head.val);
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            res.add(list);
        }
        return res;
    }
}
