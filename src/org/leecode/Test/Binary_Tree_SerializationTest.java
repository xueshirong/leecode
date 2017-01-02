package org.leecode.Test;

import org.junit.Test;
import org.leecode.Binary_Tree_Serialization;
import org.leecode.TreeNode;

public class Binary_Tree_SerializationTest {
	Binary_Tree_Serialization p  = new Binary_Tree_Serialization();
	@Test
	public void testSerialize() {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		root.right = n1;
		p.serialize(root);
	}

	@Test
	public void testDeserialize() {
		TreeNode root = p.deserialize("1 null 2 null null ");
		System.out.println(root.val);
	}

}
