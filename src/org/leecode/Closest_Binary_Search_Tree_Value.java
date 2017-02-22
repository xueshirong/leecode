package org.leecode;

public class Closest_Binary_Search_Tree_Value {
	double diff = 0.0;
    int res;
    public int closestValue(TreeNode root, double target) {
        diff = Math.abs(target - root.val);
        res = root.val;
        helper(root, target);
        return res;
    }
    private void helper(TreeNode root, double target){
    	if (root == null)
            return;
        if (Math.abs(target - root.val) < diff){
            diff = Math.abs(target - root.val);
            res = root.val;
        }
        if (target < root.val)  
            helper(root.left, target);
        else
            helper(root.right, target);
    }
    
    //solution 2
    public int closestValue1(TreeNode root, double target) {
        int res = root.val;
        double min = Double.MAX_VALUE;
        while (root != null){
            double diff = Math.abs(target - root.val);
            if (diff < min){
                min = diff;
                res = root.val;
            }
            if (target < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return res;
    }
}
