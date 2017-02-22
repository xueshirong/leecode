package org.leecode.Test;

import org.junit.Test;
import org.leecode.Closest_Binary_Search_Tree_Value;
import org.leecode.TreeNode;

public class Closest_Binary_Search_Tree_ValueTest {
	Closest_Binary_Search_Tree_Value p =new Closest_Binary_Search_Tree_Value();
	@Test
	public void testClosestValue() {
		TreeNode root = new TreeNode(41);
		TreeNode a = new TreeNode(37);
		TreeNode b = new TreeNode(76);
		TreeNode c = new TreeNode(24);
		TreeNode d = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.left = c;
		c.left = d;
		
		
		p.closestValue(root, 3.285714);
	}

}
