package org.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	//use 2 stack. One is globle, another is for level.
    //even level, add node from right to left; odd level, add node from left to right
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();//globle stack
        stack.add(root);
        boolean isNormal = true;//check if it is even or odd level
        while (!stack.isEmpty()){
            int size = stack.size();
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> temp = new Stack<TreeNode>();//level stack
            for (int i = 0; i < size; i++){
                TreeNode head = stack.pop();
                list.add(head.val);
                if (isNormal){
                    if (head.left != null)  temp.add(head.left);
                    if (head.right != null)  temp.add(head.right);
                }else{
                    if (head.right != null)  temp.add(head.right);
                    if (head.left != null)  temp.add(head.left);
                }
            }
            res.add(list);
            stack = temp;
            isNormal = !isNormal;
        }
        return res;
    }
	//.............................................
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode root) {
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
