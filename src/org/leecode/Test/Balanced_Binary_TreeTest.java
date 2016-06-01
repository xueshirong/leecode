package org.leecode.Test;

import org.junit.Test;
import org.leecode.Balanced_Binary_Tree;
import org.leecode.TreeNode;

public class Balanced_Binary_TreeTest {
	Balanced_Binary_Tree p = new Balanced_Binary_Tree();
	@Test
	public void testIsBalanced() {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		root.right = n1;
		n1.left = n2;
		p.isBalanced(root);
	}

}
