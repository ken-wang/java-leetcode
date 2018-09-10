package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.model.TreeNode;

public class AverageOfLevelsInBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {

		int depth = maxDepth(root);
		double[] sum = new double[depth];
		int[] count = new int[depth];
		cal(root, 0, sum, count);
		System.out.println(Arrays.toString(sum));
		System.out.println(Arrays.toString(count));
		List<Double> avgs = new ArrayList<>();
		for (int i = 0; i < depth; i++) {
			double avg = sum[i]/ count[i];
			avgs.add(avg);
			
		}
		return avgs;
	}

	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
	}

	private void cal(TreeNode root, int depth, double[] sum, int[] count) {
		if (root != null) {
			sum[depth] += root.val;
			count[depth]++;
			depth++;
			cal(root.left, depth, sum, count);
			cal(root.right, depth, sum, count);
		}
	}

}
