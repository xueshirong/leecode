package org.leecode.Test;

import org.junit.Test;
import org.leecode.Inorder_Successor_in_Binary_Search_Tree;
import org.leecode.TreeNode;

public class Inorder_Successor_in_Binary_Search_TreeTest {
	Inorder_Successor_in_Binary_Search_Tree p = new Inorder_Successor_in_Binary_Search_Tree();
	@Test
	public void testInorderSuccessor() {
		TreeNode root = new TreeNode(1);		
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		root.left = n2;
		root.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		TreeNode node = new TreeNode(2);
		p.inorderSuccessor(root, node);
	}

}
