package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	private static Map<Character, String[]> map = new HashMap<>();
	static {

		map.put('2', new String[] { "a", "b", "c" });
		map.put('3', new String[] { "d", "e", "f" });
		map.put('4', new String[] { "g", "h", "i" });
		map.put('5', new String[] { "j", "k", "l" });
		map.put('6', new String[] { "m", "n", "o" });
		map.put('7', new String[] { "p", "q", "r", "s" });
		map.put('8', new String[] { "t", "u", "v" });
		map.put('9', new String[] { "w", "x", "y", "z" });

	}

	public List<String> letterCombinations(String digits) {

		if (digits.length() == 0) {
			return new ArrayList<>();
		} else {
			char c = digits.charAt(0);
			List<String> resp = new ArrayList<>();
			List<String> list = letterCombinations(digits.substring(1));
			for (String digit : map.get(c)) {
				
				if (list.isEmpty()) {
					resp.add(digit);
				} else {
					for (String sub : list) {
						resp.add(digit + sub);
					}
				}
			}
			return resp;

		}
	}

}
