package org.leecode;

//Jiu Zhang - http://www.lintcode.com/en/problem/subtree-with-maximum-average/
public class Subtree_with_Maximum_Average {
	ResultType subtreeResult = null;
    TreeNode subtree = null;
    /*
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    private ResultType helper(TreeNode root){
        if (root == null)
            return new ResultType(0, 0);
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(
            left.sum + right.sum + root.val, left.size + right.size + 1
            );
        if (subtree == null || result.sum * subtreeResult.size > subtreeResult.sum * result.size){
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}

class ResultType{
    int sum;
    int size;
    public ResultType(int s, int si){
        sum = s;
        size = si;
    }
}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
