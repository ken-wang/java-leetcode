package leetcode;

import leetcode.model.TreeNode;

public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null && t2 == null) {
			return null;
		} else if (t1 != null && t2 == null) {
			return t1;
		} else if (t1 == null && t2 != null) {
			return t2;
		} else {
			TreeNode node = new TreeNode(t1.val + t2.val);
			node.right = mergeTrees(t1.right, t2.right);
			node.left = mergeTrees(t1.left, t2.left);
			return node;
		}

	}

}
