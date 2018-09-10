package leetcode;

public class ZigZagConversion {

	public String convert(String s, int numRows) {

		String[][] zigZag = new String[numRows][s.length()];
		if (numRows == 1) {
			return s;
		}

		int x = 0;
		boolean order = true;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int y = (i - x) / 2;
			System.out.println(String.format("index:%d, order:%b, (%d, %d) = %s", i, order, x, y, Character.toString(c)));
			zigZag[x][y] = Character.toString(c);

			if (order) {
				if (x >= numRows - 1) {
					x = x - 1;
				} else {
					x++;
				}

			} else {
				x--;
				if (x <= 0) {
				}
			}
			if ((x % (numRows - 1) == 0)) {
				order = !order;
			}

		}

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < zigZag.length; i++) {
			for (int j = 0; j < zigZag[i].length; j++) {
				if (zigZag[i][j] != null) {
					builder.append(zigZag[i][j]);
				}
			}
		}

		return builder.toString();

	}

}
