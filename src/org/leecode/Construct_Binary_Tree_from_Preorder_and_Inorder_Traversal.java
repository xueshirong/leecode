package org.leecode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	/**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length)
            return null;
        TreeNode root = helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
        return root;
    }
    private TreeNode helper(int[] inorder, int ins, int ine, int[] preorder, int pres, int pree){
        if (ins > ine)
            return null;
        TreeNode node = new TreeNode(preorder[pres]);
        int pos = finposition(inorder, ins, ine, node.val);
        node.left = helper(inorder, ins, pos - 1, preorder, pres + 1, pres + pos - ins);
        node.right = helper(inorder, pos + 1, ine, preorder, pres + pos - ins + 1, pree);
        return node;
    }
    private int finposition(int[] nums, int s, int e, int key){
        for (int i = s; i <= e; i++){
            if (nums[i] == key)
                return i;
        }
        return -1;
    }
}
