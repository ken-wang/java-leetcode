package leetcode;

import leetcode.model.TreeNode;

public class LeafSimilarTrees {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		int[] leaf1 = traversal(root1);
		int[] leaf2 = traversal(root2);

		if (leaf1.length != leaf2.length) {
			return false;
		}

		for (int i = 0; i < leaf1.length; i++) {
			if (leaf1[i] != leaf2[i]) {
				return false;
			}
		}

		return true;
	}

	private int[] traversal(TreeNode node) {

		if (node == null) {
			return new int[] {};
		} else if (node.right == null && node.left == null) {
			return new int[] { node.val };
		}

		int[] right = traversal(node.right);
		int[] left = traversal(node.left);
		int[] leaf = new int[right.length + left.length];

		for (int i = 0; i < right.length; i++) {
			leaf[i] = right[i];
		}
		for (int i = right.length; i < (right.length + left.length); i++) {
			leaf[i] = left[i - right.length];
		}
		return leaf;

	}

}
