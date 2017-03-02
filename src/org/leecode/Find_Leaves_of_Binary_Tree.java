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
    
    //..................
    //确定一个点的depth，得知道他的左孩子depth是多少，右孩子的depth是多少，
    //当前这个点的depth是他左右孩子的depth最大值+1，这可以很容易地观察得到。
    //比如对于1来说，左孩子2的depth是1，右孩子3的depth是0，那1depth肯定是max(1, 0) + 1，即2.
    public List<List<Integer>> findLeaves1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, res);
        return res;
    }
    //calculate the depth of this root passed in and put it in that index of res, at last return where this root was put
    private int helper(TreeNode root, List<List<Integer>> res){
        if (root == null)   return -1;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int depth = Math.max(left, right) + 1;
        if (depth == res.size()){//如果当前节点的深度超出了res的长度，说明需要new一个新的list加入到res中
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        return depth;
    }
}
