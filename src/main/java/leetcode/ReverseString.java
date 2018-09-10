package leetcode;

public class ReverseString {

	public String reverseString(String s) {

		char[] chars = s.toCharArray();
		char[] reverse = new char[chars.length];
		
		for(int i=0;i<chars.length;i++) {
			reverse[i] = chars[chars.length -i -1];
		}
		
		return String.valueOf(reverse);
		
	}
}
