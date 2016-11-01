package org.leecode.Test;

import org.junit.Test;
import org.leecode.TreeNode;
import org.leecode.Validate_Binary_Search_Tree;

public class Validate_Binary_Search_TreeTest {
	Validate_Binary_Search_Tree p = new Validate_Binary_Search_Tree();
	@Test
	public void testIsValidBST() {
		TreeNode root = new TreeNode(2);
		TreeNode node = new TreeNode(1);
		root.left = node;
		p.isValidBST(root);
	}

}
