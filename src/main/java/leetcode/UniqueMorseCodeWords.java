package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
	private static Map<Character, String> map = new HashMap<>();
	static {
		map.put('a', ".-");
		map.put('b', "-...");
		map.put('c', "-.-.");
		map.put('d', "-..");
		map.put('e', ".");
		map.put('f', "..-.");
		map.put('g', "--.");
		map.put('h', "....");
		map.put('i', "..");
		map.put('j', ".---");
		map.put('k', "-.-");
		map.put('l', ".-..");
		map.put('m', "--");
		map.put('n', "-.");
		map.put('o', "---");
		map.put('p', ".--.");
		map.put('q', "--.-");
		map.put('r', ".-.");
		map.put('s', "...");
		map.put('t', "-");
		map.put('u', "..-");
		map.put('v', "...-");
		map.put('w', ".--");
		map.put('x', "-..-");
		map.put('y', "-.--");
		map.put('z', "--..");

	}

	public int uniqueMorseRepresentations(String[] words) {

		Set<String> set = new HashSet<>();
		for (String word : words) {
			char[] elements = word.toCharArray();
			StringBuilder builder = new StringBuilder();
			for (char c : elements) {
				builder.append(map.get(c));
			}
			set.add(builder.toString());
		}

		return set.size();
	}

}
