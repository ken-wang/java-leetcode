package leetcode;

public class BinaryGap {

	public int binaryGap(int N) {
		String b = Integer.toBinaryString(N);

		int gap = 0;
		int maxGap = 0;
		for (int i = b.indexOf("1")+1; i < b.length(); i++) {
			gap++;
			if (b.charAt(i) == '1') {
				if (maxGap < gap) {
					maxGap = gap;
				}
				gap = 0;
			}
		}

		return maxGap;
	}
	
}
