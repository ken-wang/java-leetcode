package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' | c == '{' | c == '[') {
				stack.push(c);
			} else {

				if (c == ')') {
					if (stack.empty() || stack.pop() != '(') {
						return false;
					}
				}

				if (c == '}') {
					if (stack.empty() || stack.pop() != '{') {
						return false;
					}
				}

				if (c == ']') {
					if (stack.empty() || stack.pop() != '[') {
						return false;
					}
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

}
