package leetcode;

public class ShortestDistanceToACharacter {

	public int[] shortestToChar(String S, char C) {
		char[] chars = S.toCharArray();
		int[] ascending = init(S.length());
		int count = 0;
		for (int i = S.indexOf(Character.toString(C)); i < chars.length; i++) {
			if (chars[i] == C) {
				count = 0;
			}
			ascending[i] = count++;
		}

		int[] descending = init(S.length());
		count = 0;
		for (int i = S.lastIndexOf(Character.toString(C)); i >= 0; i--) {
			if (chars[i] == C) {
				count = 0;
			}
			descending[i] = count++;
		}

		int[] resp = init(S.length());
		for (int i = 0; i < resp.length; i++) {
			resp[i] = Math.min(ascending[i], descending[i]);
		}

		return resp;
	}

	private int[] init(int length) {
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = length;
		}
		return array;
	}


}
