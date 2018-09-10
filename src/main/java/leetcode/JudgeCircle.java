package leetcode;

public class JudgeCircle {

	public boolean judgeCircle(String moves) {

		int[] counts = new int[] { 0, 0, 0, 0 };
		for (char c : moves.toCharArray()) {
			switch (c) {
			case 'U':
				counts[0]++;
				break;
			case 'D':
				counts[1]++;
				break;
			case 'L':
				counts[2]++;
				break;
			case 'R':
				counts[3]++;
				break;
			}
		}

		if ((counts[0] == counts[1]) && (counts[2] == counts[3])) {
			return true;
		}
		return false;

	}

}
