package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Sum_Root_to_Leaf_Numbers {
	public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<String> res = new ArrayList<String>();
        String path = String.valueOf(root.val);
        helper(root, path, res);//get all posible numbers
        //return sum. key: over the bounderary of Integer
        double sum = 0;
        for (int i = 0; i < res.size(); i++){
            double temp = Double.parseDouble(res.get(i));
            sum += temp;
        }
        if (sum >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (sum <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)sum;
    }
    //get all path(number) from root to leaf
    private void helper(TreeNode root, String path, List<String> res){
        if (root.left == null && root.right == null){
            String temp = path;
            res.add(temp);
            return;
        }
        if (root.left != null){
            path = path + String.valueOf(root.left.val);
            helper(root.left, path, res);
            path = path.substring(0, path.length() - 1);//remove the lase char.substring do not include the endindex value
        }
        
        if (root.right != null){
            path = path + String.valueOf(root.right.val);
            helper(root.right, path, res);
            path = path.substring(0, path.length() - 1);
        }
    }
}
