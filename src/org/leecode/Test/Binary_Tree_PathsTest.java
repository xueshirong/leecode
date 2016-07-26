package org.leecode.Test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.leecode.Binary_Tree_Paths;
import org.leecode.TreeNode;

public class Binary_Tree_PathsTest {
	Binary_Tree_Paths p = new Binary_Tree_Paths();
	@Test
	public void testBinaryTreePaths() {
		//[1,2,3,null,5]
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode d = new TreeNode(5);
		root.left = a;
		root.right = b;
		a.right = d;
		p.binaryTreePaths(root);
	}

}
