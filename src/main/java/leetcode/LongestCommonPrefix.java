package leetcode;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}

		String prefix = "";
		for (int index = 0; index < strs[0].length(); index++) {
			String _prefix = strs[0].substring(0, index+1);
			for (int i = 1; i < strs.length; i++) {
//				System.out.println(String.format("prefix:%s strs[%d]:%s", _prefix, i, strs[i]));
				if (!strs[i].startsWith(_prefix)) {
					return prefix;
				}
			}
			prefix = _prefix;
		}

		return prefix;
	}

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		System.out.println(obj.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(obj.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(obj.longestCommonPrefix(new String[] { "c", "c" }));
	}
}
