package org.leecode.Test;

import org.junit.Test;
import org.leecode.Serialize_and_Deserialize_Binary_Tree;
import org.leecode.TreeNode;

public class Serialize_and_Deserialize_Binary_TreeTest {
	Serialize_and_Deserialize_Binary_Tree p = new Serialize_and_Deserialize_Binary_Tree();
	@Test
	public void testSerialize() {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		b.left = c;
		b.right = d;
		root.left = a;
		root.right = b;
		String s = p.serialize(root);
		TreeNode node = p.deserialize(s);
	}

}
