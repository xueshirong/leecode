package org.leecode;

public class Kth_Smallest_Element_in_a_BST {
	int value = 0;
    int count = 0;
    public int kthSmallest1(TreeNode root, int k) {
        count = k;
        
        helper(root);
        return value;
    }
    void helper(TreeNode root){
        if (root == null) 
            return;
        if (root.left != null)
            helper(root.left);
        count--;
        if (0 == count){
            value = root.val;
            return;
        }
        if (root.right != null)
            helper(root.right);
    }
    //---------------------
    public int kthSmallest(TreeNode root, int k) {
        int count = getcount(root.left);
        if (k <= count)
            return kthSmallest(root.left, k);
        if (k > count + 1)
            return kthSmallest(root.right, k - 1 - count);
        return root.val;
    }
    int getcount(TreeNode root){
        if (root == null)   return 0;
        return 1 + getcount(root.left) + getcount(root.right);
    }
}
