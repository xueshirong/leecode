package org.leecode;

public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {        
        return getDeepth(root) != -1;
    }
    
    int getDeepth(TreeNode node){
        if (node == null){
        	return 0;
        }
        int dl = getDeepth(node.left);
        int dr = getDeepth(node.right);
        
        if (dl == -1 || dr == -1 || Math.abs(dl - dr) > 1)
        	return -1;
        return Math.max(dl, dr) + 1;
    }
    
    //From Discuss
    boolean res = true;
    public boolean isBalanced2(TreeNode root) { 
        maxDepth(root);
        return res;
    }
    
    int maxDepth(TreeNode node){
        if (node == null){
        	return 0;
        }
        int dl = maxDepth(node.left);
        int dr = maxDepth(node.right);
        if (Math.abs(dl - dr) > 1)
        	res = false;
        return Math.max(dl, dr) + 1;
    }
}
