package org.leecode;

public class Validate_Binary_Search_Tree {
	class ResultType {
	    boolean is_bst;
	    int maxValue, minValue;
	    
	    ResultType(boolean is_bst, int maxValue, int minValue) {
	        this.is_bst = is_bst;
	        this.maxValue = maxValue;
	        this.minValue = minValue;
	    }
	}
	//From Jiu Zhang
	public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }
    
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        
        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }
        
        if (root.left != null && left.maxValue >= root.val || 
              root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true,
                              Math.max(root.val, right.maxValue),
                              Math.min(root.val, left.minValue));
    }
    
    //solution 2
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST2(TreeNode root) {
        // write your code here
        if (root == null)
            return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long min, long max){//long, not integer
        if (root == null)
            return true;
        if (root.val >= max || root.val <= min)//key point. avoid duplicated value: [1, 1]
            return false;
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        return left && right;
    }
}
