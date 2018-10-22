package leetcode;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if (s == null || numRows <= 1) {
			return s;
		}
		int len = s.length();
		char[] chars = new char[len];
		int totalSpace = numRows * 2 - 2;
		int index = 0;
		for (int step = 0; step < numRows; step++) {
			int space1 = totalSpace - step * 2;
			int space2 = step * 2;
			int i = step;
			do {
				if (space1 > 0) {
					chars[index++] = s.charAt(i);
					i += space1;
				}
				if (space2 > 0 && i < len) {
					chars[index++] = s.charAt(i);
					i += space2;
				}

			} while (i < len);

		}

		return new String(chars);
	}

	public static void main(String[] args) {
		ZigZagConversion obj = new ZigZagConversion();
		System.out.println(obj.convert("PAYPALISHIRING", 3));
		System.out.println(obj.convert("PAYPALISHIRING", 4));
	}

}
