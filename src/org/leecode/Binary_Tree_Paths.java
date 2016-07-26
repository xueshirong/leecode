package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {
	 public List<String> binaryTreePaths(TreeNode root) {
	        List<String> res = new ArrayList<String>();
	        if (root == null)
	            return res;
	        helper(res, "", root);
	        return res;
	    }
	    private void helper(List<String> res,String path, TreeNode root){
	        if (root.left == null && root.right == null)
	            res.add(path + root.val);
	        if (root.right != null)
	            helper(res, path + root.val + "->", root.right);
	        if (root.left != null)
	            helper(res, path + root.val + "->", root.left);
	    }
}
