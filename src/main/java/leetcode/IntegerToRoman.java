package leetcode;

import java.util.Stack;

public class IntegerToRoman {

	public String intToRoman2(int num) {
		String[] symbol = new String[] { "I", "V", "X", "L", "C", "D", "M", "", "" };
		Stack<String> stack = new Stack<>();
		int index = 0;
		for (int i = num; i > 0; i = i / 10) {
			int count = i % 10;
			String s = parse(count, symbol[index], symbol[index + 1], symbol[index + 2]);
			stack.push(s);
			index += 2;
		}

		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}

		return builder.toString();

	}

	public String intToRoman(int num) {

		String value = "";
		int count = num / 1000;
		value += parse(count, "M", "", "");
		num = num % 1000;

		count = num / 100;
		value += parse(count, "C", "D", "M");
		num = num % 100;

		count = num / 10;
		value += parse(count, "X", "L", "C");
		num = num % 10;

		value += parse(num, "I", "V", "X");

		return value;
	}

	private String parse(int count, String a, String b, String c) {
		if (count == 0) {
			return "";
		}

		switch (count) {
		case 9:
			return a + c;
		case 8:
			return b + a + a + a;
		case 7:
			return b + a + a;
		case 6:
			return b + a;
		case 5:
			return b;
		case 4:
			return a + b;
		case 3:
			return a + a + a;
		case 2:
			return a + a;
		case 1:
			return a;

		}

		return "";

	}

	public static void main(String[] args) {
		IntegerToRoman obj = new IntegerToRoman();

		// System.out.println(obj.intToRoman(3));
		// System.out.println(obj.intToRoman2(3));
		// System.out.println(obj.intToRoman(4));
		// System.out.println(obj.intToRoman2(4));
		// System.out.println(obj.intToRoman(9));
		// System.out.println(obj.intToRoman2(9));
		// System.out.println(obj.intToRoman(58));
		// System.out.println(obj.intToRoman2(58));
		// System.out.println(obj.intToRoman(508));
		// System.out.println(obj.intToRoman2(508));
		System.out.println(obj.intToRoman(1994));
//		System.out.println(obj.intToRoman2(1994));
//		System.out.println(obj.intToRoman(3999));
//		System.out.println(obj.intToRoman2(3999));
//		System.out.println(obj.intToRoman(2999));
//		System.out.println(obj.intToRoman2(2999));
	}

}
