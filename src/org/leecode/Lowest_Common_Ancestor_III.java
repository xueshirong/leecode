package org.leecode;

public class Lowest_Common_Ancestor_III {
	//Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
	//The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
	//Return null if LCA does not exist.
	
	//node A or node B may not exist in tree.
	/**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    boolean isA = false;
    boolean isB = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return root;
        TreeNode newnode = new TreeNode(root.val);
        newnode.left = root.left;
        newnode.right = root.right;
        findNode(newnode, A, B);
        
        TreeNode res = null;
        if (isA && isB)
            res = helper(root, A, B);
            
        return res;
    }
    
    //check 2 nodes are in the tree or not. inorder to traverse
    private void findNode(TreeNode root, TreeNode A, TreeNode B){
        if (root == null)
            return;
        if (root.val == A.val)
            isA = true;
        if (root.val == B.val)
            isB = true;
            
        findNode(root.left, A, B);
        findNode(root.right, A, B);
    }
    
    //if 2 nodes are in the tree, use standard method to continue
    private TreeNode helper(TreeNode root, TreeNode A, TreeNode B){
         if (root == null || root.val == A.val || root.val == B.val)
            return root;
            
        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);
        
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
            
        return null;
    }
}
