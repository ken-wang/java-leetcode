package leetcode;

public class ReverseInteger {

	public int reverse(int x) {
		String s = Integer.toString(x);
		try {
			if (x < 0) {
				String reverse = doReverse(s.substring(1));
				return -Integer.parseInt(reverse);
			} else {
				String reverse = doReverse(s);
				return Integer.parseInt(reverse);
			}
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private String doReverse(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			builder.append(Character.toString(c));
		}
		return builder.length() > 0 ? builder.toString() : "0";
	}

}
