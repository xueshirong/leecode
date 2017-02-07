package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Right_Side_View {
	//思路：
    //本题实际上是求二叉树每一层的最后一个节点，我们用DFS先遍历右子树并记录遍历的深度，如果这个右子节点的深度大于当前所记录的最大深度，
    //说明它是下一层的最右节点（因为我们先遍历右边，所以每一层都是先从最右边进入），将其加入结果中。
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        //corner case
        if (root == null)
            return res;
        helper1(root, 1, res);
        return res;
    }
    private void helper1(TreeNode root, int depth, List<Integer> res){
        if (depth > res.size()){//res.size() is the level number traversed. If current depth > level, the node is the first node of this level
            res.add(root.val);
        }
        if (root.right != null)
            helper1(root.right, depth + 1, res);
        if (root.left != null)
            helper1(root.left, depth + 1, res);
    }
}
