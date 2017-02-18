package org.leecode.Test;

import org.junit.Test;
import org.leecode.Binary_Tree_Upside_Down;
import org.leecode.TreeNode;

public class Binary_Tree_Upside_DownTest {
	Binary_Tree_Upside_Down p = new Binary_Tree_Upside_Down(); 
	@Test
	public void testUpsideDownBinaryTree() {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		p.UpsideDownBinaryTree3(root);
	}

}
