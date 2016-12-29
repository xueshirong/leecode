package org.leecode;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	/**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
	//Given inorder [1,2,3] and postorder [1,3,2], return a tree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //corner case
        if (inorder.length != postorder.length)
            return null;
        
        TreeNode root = helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }
    private TreeNode helper(int[] inorder, int ins, int ine, int[] postorder, int posts, int poste){
        if (ins > ine)
            return null;
        TreeNode root = new TreeNode(postorder[poste]);
        int pos = findposition(inorder, ins, ine, root.val);
        root.left = helper(inorder, ins, pos - 1, postorder, posts, posts + pos - ins - 1);
        root.right = helper(inorder, pos + 1, ine, postorder, posts + pos - ins, poste - 1);
        return root;
    }
    private int findposition(int[] nums, int s, int e, int key){
        for (int i = s; i <= e; i++){
            if (nums[i] == key)
                return i;
        }
        return -1;
    }
}
