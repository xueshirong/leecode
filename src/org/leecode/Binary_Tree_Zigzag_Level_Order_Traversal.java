package org.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //corner case
        if (root == null || (root.left == null && root.right == null))
            return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        boolean order = true;
        while (!s.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = s.size();
            Stack<TreeNode> sTemp = new Stack<TreeNode>();
            for (int i = 0; i < size; i++){
            	TreeNode head = s.pop();
                list.add(head.val);
                if (order){
                    if (head.left != null)
                        sTemp.push(head.left);
                    if (head.right != null)
                        sTemp.push(head.right);
                }
                else{
                    if (head.right != null)
                        sTemp.push(head.right);
                    if (head.left != null)
                        sTemp.push(head.left);
                }
            }
            s = sTemp;
            if (list.size() > 0)
                res.add(list);
            order = !order;
        }
        return res;
    }
}
