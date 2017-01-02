package org.leecode;

public class Binary_Tree_Serialization {
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
	StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root) {
        //corner case 
        /*if (root == null)
            return "#";
        sb.append("," + root.val);
        sb.append("," + serialize(root.left));
        sb.append("," + serialize(root.right));
        
        return sb.toString();*/
    	if (root == null) {
            sb.append("null ");
        }
        else {
            sb.append(root.val + " ");
            serialize(root.left);
            serialize(root.right);
        }

        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        //corner case
        /*if (data == "#")
            return null;
        String val = data.substring(0,data.indexOf(","));
        root = new TreeNode(Integer.valueOf(val));
        root.left = deserialize(data.substring(data.indexOf(",", data.length())));
        root.right = deserialize(data.substring(data.indexOf(",", data.length())));
        return root;*/
        
        sb = new StringBuilder(data);
        return helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (sb.length() == 0) {
            return null;
        }

        String temp = sb.substring(0, sb.indexOf(" "));
        sb = sb.delete(0,sb.indexOf(" ") + 1);
        if (temp.equals("null")) {
            root = null;
        }
        else {
            root = new TreeNode(Integer.parseInt(temp));
            root.left = helper(root.left);
            root.right = helper(root.right);
        }

        return root;
    }
}
