package org.leecode;
import java.util.Stack;

public class Binary_Search_Tree_Iterator {
	public class BSTIterator {

		TreeNode cur = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
	    public BSTIterator(TreeNode root) {
	    	cur = root;
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        if (cur != null || !stack.isEmpty())
	        	return true;
	    	return false;
	    }

	    /** @return the next smallest number */
	    public TreeNode  next() {
	    	while (cur != null) {
	            stack.push(cur);
	            cur = cur.left;
	        }
	        
	    	cur = stack.pop();
	        TreeNode node = cur;
	        cur = cur.right;
	        
	        return node;
	    }
	}
}
