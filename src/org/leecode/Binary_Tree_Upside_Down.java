package org.leecode;

public class Binary_Tree_Upside_Down {
	//Given a binary tree where all the right nodes are either leaf nodes with a sibling 
	//(a left node that shares the same parent node) or empty, 
	//flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
	//Return the new root.
	//For example:Given a binary tree {1,2,3,4,5},return the root of the binary tree [4,5,2,#,#,3,1].
	
	//最终的形态是要把siblings连起来，然后打断右孩子和原parent的连接。
	//1. find the most left node as new root.
	//2. the new root's left == parent'right
	//3. the new root's parent == parent
	//Recursion	
	public TreeNode UpsideDownBinaryTree(TreeNode root){
        return dfsBottomUp(root, null);
	}
	private TreeNode dfsBottomUp(TreeNode p, TreeNode parent){
        if(p == null)
                return parent;
        TreeNode root = dfsBottomUp(p.left,p);
        p.left = (parent == null)?parent:parent.right;
        p.right = parent;
        return root;
	}
	
	//iteration
	public TreeNode UpsideDownBinaryTree1(TreeNode root) {  
	    TreeNode node = root, parent = null, right = null;  
	    while (node != null) {  
	        TreeNode left = node.left;  
	        node.left = right;  
	        right = node.right;  
	        node.right = parent;  
	        parent = node;  
	        node = left;  
	    }  
	    return parent;  
	}
	
	//把后续遍历转换成层次遍历
	private TreeNode out = null;  
	public TreeNode UpsideDownBinaryTree2(TreeNode root) {     
	    TreeNode dummy = new TreeNode(0);  
	    dummy.left = new TreeNode(0);  
	    out = dummy;  
	      
	    postorder(root);  
	    return dummy.right;  
	}  
	      
	private void postorder(TreeNode root) {  
	    if (root == null)  
	        return;  
	      
	    postorder(root.left);  
	    postorder(root.right);  
	      
	    if (out.left == null) {  
	        out.left = root;  
	        out.left.left = null;  
	        out.left.right = null;  
	    } else if (out.right == null) {  
	        out.right = root;  
	        out.right.left = null;  
	        out.right.right = null;  
	    }  
	      
	    if (out.left != null && out.right != null)  
	        out = out.right;  
	}  
}
