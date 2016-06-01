package org.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return helper(root.left, root.right);
    }
    boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        boolean con1 = (left.val == right .val);
        boolean con2 = helper(left.left, right.right);
        boolean con3 = helper(left.right, right.left);
        return con1 && con2 && con3;                
    }
    
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root.left);
        q2.offer(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()){
        	TreeNode n1 = q1.poll();
        	TreeNode n2 = q2.poll();
        	if (n1 == null && n2 == null)
        		continue;
        	if (n1 == null || n2 == null || n1.val != n2.val)
        		return false;
        	q1.offer(n1.left);
        	q2.offer(n2.right);
        	q1.offer(n1.right);
        	q2.offer(n2.left);
        }
        
        return q1.isEmpty() && q2.isEmpty();
    }
}
