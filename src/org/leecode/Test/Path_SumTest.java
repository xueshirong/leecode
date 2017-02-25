package org.leecode.Test;

import org.junit.Test;
import org.leecode.Path_Sum;
import org.leecode.Serialize_and_Deserialize_Binary_Tree;
import org.leecode.TreeNode;

public class Path_SumTest {
	Path_Sum p = new Path_Sum();
	Serialize_and_Deserialize_Binary_Tree ss = new Serialize_and_Deserialize_Binary_Tree();
	@Test
	public void testHasPathSum() {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(-2);
		TreeNode b = new TreeNode(-3);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(-1);
		
		root.left = a;
		root.right = b;
		a.left = c;
		a.right= d;
		c.left = e;
		//p.hasPathSum2(root, 3);
		
		p.hasPathSum(root, -1);
	}

}
