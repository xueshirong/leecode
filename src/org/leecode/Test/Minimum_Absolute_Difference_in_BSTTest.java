package org.leecode.Test;

import org.junit.Test;
import org.leecode.Minimum_Absolute_Difference_in_BST;
import org.leecode.TreeNode;

public class Minimum_Absolute_Difference_in_BSTTest {
	Minimum_Absolute_Difference_in_BST p = new Minimum_Absolute_Difference_in_BST();
	@Test
	public void testGetMinimumDifference() {
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(7);
		root.left = a;
		root.right = b;
		p.getMinimumDifference(root);
	}

}
