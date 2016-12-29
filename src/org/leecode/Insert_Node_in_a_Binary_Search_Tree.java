package org.leecode;

public class Insert_Node_in_a_Binary_Search_Tree {
	 /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        //corner case
        if (root == null && node != null)
            return node;
        else if (node == null)
            return root;
            
        helper(root, node);
        return root;
    }
    private void helper(TreeNode root, TreeNode node){
        if (node.val == root.val)
            return;
        if (root.left == null && node.val < root.val){
            root.left = node;
            return;
        }else if (root.right == null && node.val > root.val){
            root.right = node;
            return;
        }
        
        if (node.val < root.val && root.left != null)
            helper(root.left, node);
        else if (node.val > root.val && root.right != null)
            helper(root.right, node);
    }
}
