package leetcode;

import leetcode.model.TreeNode;

public class InsertIntoABinarySearchTree {
	public TreeNode insertIntoBST(TreeNode root, int val) {

		if (val < root.val) {
			if (root.left != null) {
				insertIntoBST(root.left, val);
			} else {
				root.left = new TreeNode(val);
			}
		} else {
			if (root.right != null) {
				insertIntoBST(root.right, val);
			} else {
				root.right = new TreeNode(val);
			}
		}
		return root;
	}

}
