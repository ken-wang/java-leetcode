package leetcode;

public class HammingDistance {

	public int hammingDistance(int x, int y) {

		char[] _x = flip(Integer.toBinaryString(x).toCharArray());
		char[] _y = flip(Integer.toBinaryString(y).toCharArray());
		if (x > y) {
			return count(_x, _y);
		} else {
			return count(_y, _x);
		}

	}

	private int count(char[] max, char[] min) {
		int count = 0;
		for (int i = 0; i < max.length; i++) {
			if (i >= min.length && max[i] == '1') {
				count++;
			} else if (i < min.length && max[i] != min[i]) {
				count++;
			}
		}
		return count;
	}

	private char[] flip(char[] chars) {
		for (int i = 0; i < (chars.length / 2); i++) {
			char c = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = c;
		}
		return chars;
	}

}
