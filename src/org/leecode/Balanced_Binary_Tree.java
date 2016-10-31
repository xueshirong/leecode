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
    
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    //From Jiu Zhang
    public boolean isBalanced3(TreeNode root) {
        // write your code here
        if (root == null)
            return true;
        
        if (helper(root) == -1)
            return false;
        return true;
    }
    private int helper(TreeNode root){
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        if (left == -1 || right == -1 || Math.abs(left -right) > 1)
            return -1;
        return (Math.max(left, right) + 1);
    }
    
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    //From Jiu Zhang
    class subType{
        public boolean isBlanced;
        public int depth;
        public subType(boolean isBlanced, int depth){
            this.isBlanced = isBlanced;
            this.depth = depth;
        }
    }
    public boolean isBalanced5(TreeNode root) {
        // write your code here
        subType res = helper5(root);
        return res.isBlanced;
    }
    private subType helper5(TreeNode root){
        if (root == null)
            return new subType(true, 0);
            
        subType left = helper5(root.left);
        subType right = helper5(root.right);
        
        if (!left.isBlanced || !right.isBlanced)
            return new subType(false, -1);
        
        if (Math.abs(left.depth - right.depth) > 1)
            return new subType(false, -1);
            
        return new subType(true, Math.max(left.depth, right.depth) + 1);
    }
}
