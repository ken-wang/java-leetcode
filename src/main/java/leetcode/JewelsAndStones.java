package leetcode;

public class JewelsAndStones {

	public static int numJewelsInStones(String J, String S) {
		
		char[] jewels = J.toCharArray();
		char[] stones = S.toCharArray();
		int count = 0;
		for (int i = 0; i < jewels.length; i++) {
			for (int j = 0; j < stones.length; j++) {
				if (jewels[i] == stones[j]) {
					count++;
				}
			}
		}
		return count;
	}

}
