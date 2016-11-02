package org.leecode;

public class Lowest_Common_Ancestor {
	/**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
	//Given the root and two nodes in a Binary Tree. 
	//Find the lowest common ancestor(LCA) of the two nodes.
	//The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // Exit
        if (root == null || root == A || root == B)
            return root;
        
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        //Conqure
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
            
        return null;
    }
}
