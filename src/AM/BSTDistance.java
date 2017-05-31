
package AM;

import org.leecode.TreeNode;

public class BSTDistance {
	private static TreeNode root;

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
		
		int d1 = distance(root, node1);// distance between node1 and root
		if (d1 < 0)	return -1;//node1 is not in the BST, return -1;
		int d2 = distance(root, node2);// distance between node2 and root
		if (d2 < 0)	return -1;//node2 is not in the BST, return -1;
		
		int lcaVal = lowestCommonAncestor(root, node1, node2).val;// find LCA value
		int dlca = distance(root, lcaVal);// distance between lca node and
											// root
		int distance = (d1 + d2) - 2 * dlca;// distance between node1 and node2
		return distance;
	}

	// Generate BST with unsorted array
	public static void buildBST(int[] values, int n) {
		root = new TreeNode(values[0]);// initial the root

		for (int i = 1; i < n; i++) {// loop to add each value to BST
			addNode(root, values[i]);
		}
	}

	// add new node to BST
	public static void addNode(TreeNode node, int val) {
		if (val < node.val) {// add new node to left
			if (node.left == null) {
				node.left = new TreeNode(val);
			} else {
				addNode(node.left, val);
			}
		} else if (val > node.val) {// add new node to right
			if (node.right == null) {
				node.right = new TreeNode(val);
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

	public static int distance(TreeNode root, int node) {
		return distancehHelp(root, node) - 1;
	}
	
	public static int distancehHelp(TreeNode root, int node) {
		if (root == null)	return 0;
		
		int dl = distancehHelp(root.left, node);
		int dr = distancehHelp(root.right, node);
		if (root.val == node || dl > 0 || dr > 0) {
			return Math.max(dl, dr) + 1;
		}		
		return 0;
	}
}