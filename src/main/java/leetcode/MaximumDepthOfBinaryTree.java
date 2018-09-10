package leetcode;

import leetcode.model.TreeNode;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}

	}
}
