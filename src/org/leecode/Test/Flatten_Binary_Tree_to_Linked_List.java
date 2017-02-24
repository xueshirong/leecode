package org.leecode.Test;

import org.leecode.TreeNode;

public class Flatten_Binary_Tree_to_Linked_List {
	//from jiu zhang
	//前序遍历，记录下前一个lastnode,将当前node加入到lastnode的右边
    private TreeNode lastnode = null;
    public void flatten2(TreeNode root) {
        if (root == null)   return;
        if (lastnode != null){//将当前node加入到前一个node的右边
            lastnode.right = root;
            lastnode.left = null;
        }
        lastnode = root;//记录当前node
        TreeNode right = root.right;//由于将会修改root.right，因此先将其保存下来
        flatten(root.left);
        flatten(right);
    }
    
  //链接左右子树法  时间 O(N) 空间 O(1)
    //思路: 如果我们将根节点的右子树接到左子树最后一个节点（就是左子树尽可能靠右下的节点）的右边，
    //那我们可以确定的是，该根节点是已经flat的了。执行完该链接操作，根节点就只有右子树了，这样我们再移动到右子树的根节点，
    //反复执行同样的操作，每次保证一个节点被flat。
    public void flatten(TreeNode root) {//从上往下的迭代
        while(root != null){
            // 当存在左子树时，说明该节点还没被flat
            if(root.left != null){
                // 找到左子树最后一个节点
                TreeNode endOfLeftSubTree = root.left;
                while(endOfLeftSubTree.right != null){
                    endOfLeftSubTree = endOfLeftSubTree.right;
                }
                // 将右子树加到左子树最后一个节点的右边
                endOfLeftSubTree.right = root.right;
                // 将左子树放到当前节点的右边
                root.right = root.left;
                // 将当前节点左边置空
                root.left = null;
            }
            // 移动到下一个待flat的节点
            root = root.right;
        }
    }
    
    //前序遍历，将最左孩子插入到有孩子的前面
    public void flatten1(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root){
        if (root == null)
            return root;
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        if (root.left != null){//insert left to root.right
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            leftTail.right = temp;
        }
        if (rightTail != null)   return rightTail;
        if (leftTail != null)   return leftTail;
        return root;
    }
}
