
package AM;
import java.util.*;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) {
		val = x; 
	}
}

public class BSTDistance_1 {
	//root of tree
	private static TreeNode root;
	//Hashtable save the treenode and distance to root
	private static Hashtable<Integer, Integer> distTable = new Hashtable<Integer, Integer>();

	public static void main(String[] args) {
		int values[] = { 5, 6, 3, 1, 2, 4 };
		int res = -1;
		res = bstDistance(values, 6, 12, 7);//output is -1
		System.out.println(res);
		res = bstDistance(values, 6, 0, -1);//output is -1
		System.out.println(res);
		res = bstDistance(values, 6, 0, 7);//output is -1
		System.out.println(res);
		res = bstDistance(values, 6, 7, 2);//output is -1
		System.out.println(res);
		res = bstDistance(values, 6, 2, 6);//output is 4
		System.out.println(res);
		res = bstDistance(values, 6, 2, 2);//output is 0
		System.out.println(res);
		res = bstDistance(values, 6, 1, 2);//output is 1
		System.out.println(res);
		res = bstDistance(values, 6, 5, 4);//output is 2
		System.out.println(res);
		res = bstDistance(values, 6, 5, 5);//output is 0
		System.out.println(res);
	}

	public static int bstDistance(int[] values, int n, int node1, int node2) {
		if (values == null || values.length == 0)// Empty tree, return -1;
			return -1;

		buildBST(values, n);//generate BST
		
		if (distTable.get(node1) == null || distTable.get(node2) == null)//if node1 or node2 is not in tree, return -1
		    return -1;
		
		int lcaVal = lowestCommonAncestor(root, node1, node2).val;// find LCA value
		int distance = (distTable.get(node1) + distTable.get(node2)) - 2 * distTable.get(lcaVal);// distance between node1 and node2
		return distance;
	}

	// Generate BST with unsorted array
	public static void buildBST(int[] values, int n) {
		root = new TreeNode(values[0]);// initial the root
		distTable.put(values[0], 0);

		for (int i = 1; i < n; i++) {// loop to add each value to BST
			addNode(root, values[i]);
		}
	}

	// add new node to BST
	public static void addNode(TreeNode node, int val) {
		if (val < node.val) {// add new node to left
			if (node.left == null) {
				node.left = new TreeNode(val);
				distTable.put(val, distTable.get(node.val) + 1);
			} else {
				addNode(node.left, val);
			}
		} else if (val > node.val) {// add new node to right
			if (node.right == null) {
				node.right = new TreeNode(val);
				distTable.put(val, distTable.get(node.val) + 1);
			} else {
				addNode(node.right, val);
			}
		}
	}

	//find the lowest common ancestor node in the BST
	public static TreeNode lowestCommonAncestor(TreeNode root, int node1, int node2) {
		if (root == null || root.val == node1 || root.val == node2)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, node1, node2);
		TreeNode right = lowestCommonAncestor(root.right, node1, node2);

		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		if (right != null)
			return right;

		return null;
	}
}