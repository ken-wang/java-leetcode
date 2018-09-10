package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfLinesToWriteString {

	public int[] numberOfLines(int[] widths, String S) {

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < widths.length; i++) {
			map.put((char) (i + 97), widths[i]);
		}

		int[] resp = new int[] { 1, 0 };
		for (char c : S.toCharArray()) {

			if ((resp[1] + map.get(c)) > 100) {
				resp[0]++;
				resp[1] = map.get(c);
			} else {
				resp[1] += map.get(c);
			}

		}

		return resp;

	}

}
