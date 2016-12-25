package org.leecode.Test;

import org.junit.Test;
import org.leecode.Identical_Binary_Tree;
import org.leecode.TreeNode;

public class Identical_Binary_TreeTest {
	Identical_Binary_Tree p = new Identical_Binary_Tree();
	@Test
	public void testIsIdentical() {
		TreeNode a = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		a.left = a2;
		a.right = a3;
		a2.left = a4;	
		
		TreeNode b = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		TreeNode b3 = new TreeNode(3);
		TreeNode b4 = new TreeNode(4);
		b.left = b2;
		b.right = b3;
		b2.right = b4;		
		
		p.isIdentical(a, b);
	}

}
