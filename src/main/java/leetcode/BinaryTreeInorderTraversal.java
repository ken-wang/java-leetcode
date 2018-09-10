package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		} else {
			List<Integer> left = inorderTraversal(root.left);
			left.add(root.val);
			List<Integer> right = inorderTraversal(root.right);
			left.addAll(right);
			return left;
		}
	}
}
