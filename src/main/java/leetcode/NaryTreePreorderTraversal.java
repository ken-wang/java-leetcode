package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.Node;

public class NaryTreePreorderTraversal {

	public List<Integer> preorder(Node root) {

		if (root == null) {
			return new ArrayList<>();
		} else {
			List<Integer> traversal = new ArrayList<>();
			traversal.add(root.val);
			for (int i = 0; i < root.children.size(); i++) {
				traversal.addAll(preorder(root.children.get(i)));
			}
			return traversal;
		}

	}
}
