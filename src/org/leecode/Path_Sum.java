package org.leecode;

public class Path_Sum {
	//From Jiu Zhang
	//1. 和min/max depth那两题类似，同样属于binary tree root->leaf path类的题目。思路也是递归，直到找到leaf为止。
    //2. 传递的path变量：
    //(1) 可以是当前path上已经访问过的所有节点的sum。这样到leaf时判断是否与目标sum相等
    //(2) 也可以是目标sum减去当前path上已经访问的所有节点的sum。这样到leaf时，只要判断leaf节点的值是否等于传递下来的剩余sum即可。
	public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum2 (root.left, sum - root.val)
            || hasPathSum2(root.right, sum - root.val);
    }
	
    //........(1)当前path上已经访问过的所有节点的sum
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return help(root, root.val, sum);
    }
    boolean help(TreeNode root, int cur, int sum){
        if (root != null && root.left == null && root.right == null){
            if (cur == sum)
            	return true;
            else
                return false;
        }
        
        if (root.left != null && help(root.left, cur + root.left.val, sum)) return true;
        if (root.right != null && help(root.right, cur + root.right.val, sum)) return true;
        
        return false;
    }
}
