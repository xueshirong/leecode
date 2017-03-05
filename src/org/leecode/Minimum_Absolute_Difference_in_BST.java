package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimum_Absolute_Difference_in_BST {
	//思路：
    //(1)先序遍历二叉树，得到的遍历结果存入List；
    //(2)对List进行排序，遍历List，依次判断每相邻两个值的差是否小于最小值result，是则更新result。
    public int getMinimumDifference1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper1(root, list);
        Collections.sort(list);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++){
            int dif = list.get(i) - list.get(i - 1);
            if (dif < res)
                res = dif;
        }
        return res;
    }
    private void helper1(TreeNode root, List<Integer> list){
        if (root == null)
            return;
        list.add(root.val);
        helper1(root.left, list);
        helper1(root.right, list);
    }
    
    //solution 2,速度快 用inorder 遍历树，即顺序遍历每个数，得到最小值
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null)  return 0;
        int res = helper(root);
        return res;
    }
    private int helper(TreeNode root){//key point: 穿入前序节点
        if (root == null)   return min;
        helper(root.left);
        if (pre != null){
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        helper(root.right);
        return min;
    }
}
