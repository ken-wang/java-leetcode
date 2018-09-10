package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		return doGenerateParenthesis(n, n);
	}

	private List<String> doGenerateParenthesis(int left, int right) {
		List<String> list = new ArrayList<>();
		if (left == 0 && right == 1) {
			list.add(")");
			return list;
		}
		if (right >= left) {
			if (right == left) {
				for (String sub : doGenerateParenthesis(left - 1, right)) {
					list.add("(" + sub);
				}
			} else {
				if (left > 0) {
					for (String sub : doGenerateParenthesis(left - 1, right)) {
						list.add("(" + sub);
					}
				}
				for (String sub : doGenerateParenthesis(left, right - 1)) {
					list.add(")" + sub);
				}
			}
		}

		return list;
	}

}
