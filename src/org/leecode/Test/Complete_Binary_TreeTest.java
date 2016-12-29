package org.leecode.Test;

import org.junit.Test;
import org.leecode.Complete_Binary_Tree;
import org.leecode.TreeNode;

public class Complete_Binary_TreeTest {
	Complete_Binary_Tree p = new Complete_Binary_Tree();
	@Test
	public void testIsComplete() {
		TreeNode b = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		TreeNode b3 = new TreeNode(3);
		TreeNode b4 = new TreeNode(4);
		b.left = b2;
		b.right = b3;
		b2.right = b4;	
		p.isComplete(b);
	}
}
