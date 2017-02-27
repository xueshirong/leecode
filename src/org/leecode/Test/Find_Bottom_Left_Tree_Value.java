package org.leecode.Test;

import java.util.LinkedList;
import java.util.Queue;

import org.leecode.TreeNode;

public class Find_Bottom_Left_Tree_Value {
	public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int res = root.val;
        while (!q.isEmpty()){
            int size = q.size();
            res = q.peek().val;
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if (node.left != null)  q.offer(node.left);
                if (node.right != null)  q.offer(node.right);
            }
        }
        return res;
    }
}
