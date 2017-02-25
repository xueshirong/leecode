package org.leecode;

import java.util.ArrayList;

public class Inorder_Successor_in_Binary_Search_Tree {
	//Given a binary search tree (See Definition) and a node in it, 
	//find the in-order successor of that node in the BST.
	//If the given node has no in-order successor in the tree, return null.
	public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        // write your code here
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        helper(res, root);
        
        int index = -1;
        for(int i = 0; i < res.size(); i++){
            if (res.get(i).val == p.val){
                index = i + 1;
                break;
            }
        }
        if (index <= 0 || index == res.size())
            return null;
        return res.get(index);
    }
    private void helper(ArrayList<TreeNode> res, TreeNode root){
        if (root == null)
            return;
        helper(res, root.left);
        res.add(root);
        helper(res, root.right);
    }
    
    //思路: 一种较为通用的方法是中序遍历一遍二叉树,记录结点的前一个结点,这样当前一个结点为p时,
    //当前结点就是p的后继结点.这种方法适用于一般二叉树,时间复杂度为O(n).
    private TreeNode pre = null;
    private TreeNode res = null;
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
        helper(root, p);
        return res;
    }
    private void helper(TreeNode root, TreeNode p){
        if (root == null)
            return;
        helper(root.left, p);
        if (pre != null && pre.val == p.val){
            res = root;
        }
        pre = root;
            
        helper(root.right, p);
    }
    
    //The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
    //root.val > p.val. In this case, root can be a possible answer, so we store the root node first and call it res. However, we don't know if there is anymore node on root's left that is larger than p.val. So we move root to its left and check again.
    //root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child. So we only need to consider root's right child, thus we move root to its right and check again.
    //We continuously move root until exhausted. To this point, we only need to return the res in case 1.
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
        TreeNode res = null;
        while(root != null){
            if (root.val > p.val){
                res = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }
}
