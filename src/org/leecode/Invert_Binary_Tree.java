package org.leecode;

public class Invert_Binary_Tree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
            return null;
		
		TreeNode tmpNode = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmpNode);
		
		return root;
	}
	
	public TreeNode invertTree00(TreeNode root) {
		if (root == null)
            return null;
		if (root.left != null && root.right == null){
		    root.right =  new TreeNode(0);
		    
			root.right.left = root.left.left;
			root.right.right = root.left.right;
			root.right.val = root.left.val;
			
			root.left = null;
			root.right = invertTree(root.right);
			return root;
		}
		
		if (root.left == null && root.right != null){
		    root.left =  new TreeNode(0);
		    
			root.left.left = root.right.left;
			root.left.right = root.right.right;
			root.left.val = root.right.val;
			
			root.right = null;
			root.left = invertTree(root.left);
			return root;
		}
		
        if (root.left != null && root.right != null){
            root = swap(root);
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }        
        return root;    
    }
    public TreeNode swap(TreeNode node){
        TreeNode tmpNode = new TreeNode(4);
        tmpNode.left = node.left.left;
        tmpNode.right = node.left.right;
        tmpNode.val = node.left.val;
        
        node.left.left = node.right.left;
        node.left.right = node.right.right;
        node.left.val = node.right.val;
        
        node.right.left = tmpNode.left;
        node.right.right = tmpNode.right;
        node.right.val = tmpNode.val;
        
        return node;
    }
}
