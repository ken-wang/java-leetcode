package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	private static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);
	}

	public int romanToInt(String s) {

		int sum = 0;
		int above = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int value = map.get(c);
			if (value <= above) {
				sum += value;
			} else {
				sum += (value - 2 * above);
			}
			above = value;
		}
		return sum;
	}
}
