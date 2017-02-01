package org.leecode.Test;

import org.junit.Test;
import org.leecode.Sum_Root_to_Leaf_Numbers;
import org.leecode.TreeNode;

public class Sum_Root_to_Leaf_NumbersTest {
	Sum_Root_to_Leaf_Numbers p = new Sum_Root_to_Leaf_Numbers();
	@Test
	public void testSumNumbers() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		p.sumNumbers(root);
	}

}
