package leetcode;

public class ReverseWordsInAStringIII {

	public String reverseWords(String s) {
		
		String[] strings = s.split(" ");
		StringBuilder builder = new StringBuilder();
		for(String string : strings) {
			builder.append(reverse(string));
			builder.append(" ");
		}
		builder.setLength(builder.length() -1);
		return builder.toString();
	}
	
	private String reverse(String s) {
		
		char[] chars = s.toCharArray();
		char[] reverse = new char[chars.length];
		
		for(int i=0;i<chars.length;i++) {
			reverse[i] = chars[chars.length -i -1];
		}
		
		return String.valueOf(reverse);
	}
	
}
