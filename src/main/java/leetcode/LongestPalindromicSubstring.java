package leetcode;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {

		String longest = "";
		for (int i = 0; i < s.length(); i++) {

			for (int index = s.length(); index > i; index--) {
				String sub = s.substring(i, index);
				if (longest.length() > sub.length()) {
					break;
				}
				if (isPalindromic(sub)) {
					longest = sub;
					break;
				}
			}
		}
		return longest;

	}

	private boolean isPalindromic(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;

	}

}
