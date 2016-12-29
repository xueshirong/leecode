package org.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class Complete_Binary_Tree {
	//Check a binary tree is completed or not. 
	//A complete binary tree is a binary tree that every level is completed filled except the deepest level. 
	//In the deepest level, all nodes must be as left as possible. See more definition
	/**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
	/**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    //All left node must be full, then right node can have child
    public boolean isComplete(TreeNode root) {
        //corner case
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean isbottom = false;
        while (!q.isEmpty()){
            TreeNode head = q.poll();
            
            if (head.left != null){
                if (isbottom)//check previous iteration is already in bottom
                    return false;
                else
                    q.add(head.left);
            }else
                isbottom = true;
                
            if (head.right != null){
                if (isbottom)
                    return false;
                else
                    q.add(head.right);
            }else
                isbottom = true;
        }
        return true;
    }
}
