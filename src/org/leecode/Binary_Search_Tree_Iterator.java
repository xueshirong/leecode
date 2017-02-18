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
	    //非递归的中序遍历，获取下一个。
	    //维护一个栈，从根节点开始，每次迭代地将根节点的左孩子压入栈，直到左孩子为空为止。
	    //调用next()方法时，弹出栈顶，如果被弹出的元素拥有右孩子，则以右孩子为根，将其左孩子迭代压栈。
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
