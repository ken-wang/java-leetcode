package leetcode;

public class LongestPalindromicSubstring {

	private int minIndex, maxIndex, max;
	private char[] chars;

	public String longestPalindrome(String s) {

		this.chars = s.toCharArray();
		for (int i = 0; i < this.chars.length; i++) {
			calculate(i, i);
			calculate(i, i + 1);
		}
		return s.substring(this.minIndex, this.maxIndex);
	}

	private void calculate(int start, int end) {

		while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
			start--;
			end++;
		}

		if (this.max <= end - start - 1) {
			this.max = end - start - 1;
			this.minIndex = start + 1;
			this.maxIndex = end;
		}

	}

	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		System.out.println(obj.longestPalindrome("babad"));
		System.out.println(obj.longestPalindrome(
				"dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"));
	}

}
