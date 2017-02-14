package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Find_Leaves_of_Binary_Tree {
	//DFS  思路 O(n)
	//Leaves may at different levels in the tree, we need to group nodes by its max distance to subtree leaves. 
	//So the group has distance 0, second has distance 1, and so on...
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, root);
        return list;
    }
	//calculate the index of this root passed in and put it in that index, at last return where this root was put
    private int helper(List<List<Integer>> list, TreeNode root) {
        if (root == null)
            return -1;
        int leftdepth = helper(list, root.left);
        int rightdepth = helper(list, root.right);
        int cur = Math.max(leftdepth, rightdepth) + 1;
        if (list.size() == cur)
            list.add(new ArrayList<Integer>());
        list.get(cur).add(root.val);
        return cur;
    }
}
