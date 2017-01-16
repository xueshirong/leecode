package org.leecode.Test;

import org.junit.Test;
import org.leecode.Binary_Tree_Serialization;
import org.leecode.Binary_Tree_Zigzag_Level_Order_Traversal;
import org.leecode.TreeNode;

public class Binary_Tree_Zigzag_Level_Order_TraversalTest {
	Binary_Tree_Zigzag_Level_Order_Traversal p = new Binary_Tree_Zigzag_Level_Order_Traversal();
	Binary_Tree_Serialization treetest  = new Binary_Tree_Serialization();
	@Test
	public void testZigzagLevelOrder() {
		String data = "3,9,20,#,#,15,7";
		TreeNode root = treetest.deserialize(data);
		p.zigzagLevelOrder(root);
	}

}
