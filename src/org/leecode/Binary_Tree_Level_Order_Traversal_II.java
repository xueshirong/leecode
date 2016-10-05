package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II {
	//DFS.From Discuss. solution is same, the only different is the last clause
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, TreeNode root, int height){
        if (root == null)
            return;
        if (res.size() <= height)
            res.add(0, new ArrayList<Integer>());
        
        helper(res, root.left, height + 1);
        helper(res, root.right, height + 1);
        res.get(res.size()-height - 1).add(root.val);//key point. this clause means add val from back to head
    }
    
  //BFS
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
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
                if (head != null)
                    list.add(head.val);
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
