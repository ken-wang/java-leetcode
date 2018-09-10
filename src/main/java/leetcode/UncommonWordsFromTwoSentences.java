package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UncommonWordsFromTwoSentences {

	public String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : A.split(" ")) {
			if(map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, ++count);
			} else {
				map.put(word, 1);
			}
		}
		for (String word : B.split(" ")) {
			if(map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, ++count);
			} else {
				map.put(word, 1);
			}
		}

		List<String> words = map.entrySet().parallelStream().filter(entry -> {
			if (entry.getValue() <= 1) {
				return true;
			}
			return false;

		}).map(entry -> entry.getKey()).collect(Collectors.toList());
		return words.toArray(new String[words.size()]);
	}
	
}
