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
    //From Jiu Zhang BFS
    public ArrayList<ArrayList<Integer>> levelOrder4(TreeNode root) {
    	// write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();//size of queue is changing, so must get it beforehand
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
    //From Jiu Zhang 2 queue
    public ArrayList<ArrayList<Integer>> levelOrder5(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        //q1 is used to store current level nodes
        ArrayList<TreeNode> q1 = new ArrayList<TreeNode>();
        //q1 is used to store next level nodes
        ArrayList<TreeNode> q2 = new ArrayList<TreeNode>();
        q1.add(root);
        while (!q1.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            q2.clear();
            for (int i = 0; i < q1.size(); i++){
                TreeNode node = q1.get(i);
                level.add(node.val);
                if (node.left != null)
                    q2.add(node.left);
                if (node.right != null)
                    q2.add(node.right);
            }
            //swap q1 q2
            ArrayList<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
            
            res.add(level);
        }
        return res;
    }
}
