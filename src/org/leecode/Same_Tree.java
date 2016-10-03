package org.leecode;

public class Same_Tree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q == null)
            return false;
        else if (p == null && q != null)
            return false;
        else if (p != null && q != null){
            if (p.val != q.val)
                return false;
            
            boolean isSame = isSameTree(p.left, q.left);
            if (!isSame)
                return false;
            isSame = isSameTree(p.right, q.right);
            if (!isSame)
                return false;
            
        }
        return true;
    }
	//From Leetcode
	public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        boolean left = false;
        boolean right = false;
        if (p.val == q.val){//if vals are same, then check left and right node
            left = isSameTree(p.left, q.left);
            right = isSameTree(p.right, q.right);
        }
        return (left && right);
    }
}
