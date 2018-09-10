package leetcode;

public class NumberComplement {

	public int findComplement(int num) {

		String binary = Integer.toBinaryString(num);
		char[] chars = binary.toCharArray();
		
		for (int i=0;i<chars.length;i++) {
			if(chars[i] == '0') {
				chars[i] = '1';
			}else {
				chars[i] = '0';
			}
		}
		return Integer.parseUnsignedInt(new String(chars), 2);
		
	}

}
