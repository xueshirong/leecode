package org.leecode.Test;

import org.junit.Test;
import org.leecode.Path_Sum;
import org.leecode.TreeNode;

public class Path_SumTest {
	Path_Sum p = new Path_Sum();
	@Test
	public void testHasPathSum() {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		root.left = a;
		p.hasPathSum2(root, 3);
	}

}
