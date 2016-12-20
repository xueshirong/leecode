package org.leecode.Test;

import org.junit.Test;
import org.leecode.Lowest_Common_Ancestor_III;
import org.leecode.TreeNode;
import org.leecode.Common.Utility;

public class Lowest_Common_Ancestor_IIITest {
	Lowest_Common_Ancestor_III p  = new Lowest_Common_Ancestor_III();
	@Test
	public void testLowestCommonAncestor3() {
		int[] list = new int[]{1,2,3,Integer.MAX_VALUE,3};
		TreeNode root = Utility.getTestTreeNode(list);
		root = new TreeNode(31);
		TreeNode a = new TreeNode(11);
		TreeNode b = new TreeNode(51);
		root.left = a;
		root.right = b;
		TreeNode c = new TreeNode(8);
		a.left = c;
		TreeNode e = new TreeNode(41);
		TreeNode f = new TreeNode(61);
		b.left = e;
		b.right = f;		
		
		p.lowestCommonAncestor3(root, new TreeNode(41), new TreeNode(61));
	}

}
