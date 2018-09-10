package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.Node;

public class NaryTreePostorderTraversal {

	public List<Integer> postorder(Node root) {

		if (root == null) {
			return new ArrayList<>();
		} else {
			List<Integer> traversal = new ArrayList<>();
			for (int i = 0; i < root.children.size(); i++) {
				traversal.addAll(postorder(root.children.get(i)));
			}
			traversal.add(root.val);
			return traversal;
		}
	}

}
