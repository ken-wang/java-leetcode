package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		} else {
			List<Integer> left = postorderTraversal(root.left);
			List<Integer> right = postorderTraversal(root.right);
			left.addAll(right);
			left.add(root.val);
			return left;
		}
	}

}
