package leetcode;

import java.util.List;
import java.util.stream.Collectors;

import leetcode.model.Node;

public class MaximumDepthOfNaryTree {

	public int maxDepth(Node root) {

		if (root == null) {
			return 0;
		} else {
			List<Integer> depths = root.children
					.parallelStream()
					.map(child -> maxDepth(child))
					.collect(Collectors.toList());

			int max = 0;
			for (Integer depth : depths) {
				if (max < depth) {
					max = depth;
				}
			}
			return 1 + max;
		}

	}
}
