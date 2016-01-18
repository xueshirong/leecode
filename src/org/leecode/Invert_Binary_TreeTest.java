package org.leecode;

import org.junit.Before;
import org.junit.Test;

public class Invert_Binary_TreeTest {

	Invert_Binary_Tree iBT = new Invert_Binary_Tree();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInvertTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		iBT.invertTree(root);
	}

}
