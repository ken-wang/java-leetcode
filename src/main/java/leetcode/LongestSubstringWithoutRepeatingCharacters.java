package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

//		char[] chars = s.toCharArray();
//		int max = 0;
//		Set<Character> set = new HashSet<>();
//		for (int i = 0; i < chars.length; i++) {
//			int count = 0;
//			for (int j = i; j < chars.length; j++) {
//				if (set.contains(chars[j])) {
//					break;
//				} else {
//					set.add(chars[j]);
//					count++;
//				}
//			}
//			set.clear();
//			max = Math.max(max, count);
//			
//			if (max > chars.length -i) {
//				break;
//			}
//		}
//
//		return max;
		
		 int n = s.length(), ans = 0;
	        int[] index = new int[128]; // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            i = Math.max(index[s.charAt(j)], i);
	            ans = Math.max(ans, j - i + 1);
	            index[s.charAt(j)] = j + 1;
	        }
	        return ans;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(obj.lengthOfLongestSubstring("bbbb"));
//		System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
	}
}
