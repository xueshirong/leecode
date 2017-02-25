package org.leecode;

public class Serialize_and_Deserialize_Binary_Tree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }
    
    private void helper(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("x").append(",");
        }else{
            sb.append(root.val).append(",");
            helper(root.left, sb);
            helper(root.right, sb);
        }
    }

    private String s = "";
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        s = data;
        return helper1(root);
        //return root;
    }
    private TreeNode helper1(TreeNode root){
        if (s.equals(""))
            return null;
        String val = s.substring(0, s.indexOf(","));
        s = s.substring(s.indexOf(",") + 1, s.length());
        if (val.equals("x")){
            root = null;
        }else{
            root = new TreeNode(Integer.valueOf(val));
            root.left = helper1(root.left);
            root.right = helper1(root.right);
        }
        return root;
    }
}
