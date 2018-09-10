package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyboardRow {

	private static final Set<String> set = new HashSet<>();
	static {
		set.add("qwertyuiop");
		set.add("asdfghjkl");
		set.add("zxcvbnm");
		set.add("1234567890");
	}

	public String[] findWords(String[] words) {
		
		List<String> _words = new ArrayList<>();
		for (String word : words) {
			if (check(word.toLowerCase())) {
				_words.add(word);
			}
		}
		return _words.toArray(new String[_words.size()]);
	}

	private boolean check(String str) {

		boolean result = false;
		char[] chars = str.toCharArray();
		for (String keys : set) {
			if (keys.contains(String.valueOf(chars[0]))) {
				result = true;
				for (int i = 1; i < chars.length; i++) {
					if (!keys.contains(String.valueOf(chars[i]))) {
						result = false;
						break;
					}
				}
			}
			if (result) {
				break;
			}

		}
		return result;

	}

}
