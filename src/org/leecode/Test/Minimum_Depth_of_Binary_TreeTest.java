package org.leecode.Test;

import org.junit.Test;
import org.leecode.Minimum_Depth_of_Binary_Tree;
import org.leecode.TreeNode;

public class Minimum_Depth_of_Binary_TreeTest {
	Minimum_Depth_of_Binary_Tree p = new Minimum_Depth_of_Binary_Tree();
	@Test
	public void testMinDepth2() {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		root.left = a;
		p.minDepth2(root);
	}

}
