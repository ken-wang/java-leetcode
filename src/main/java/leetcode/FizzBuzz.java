package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public List<String> fizzBuzz(int n) {

		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 != 0 && i % 5 != 0) {
				list.add(Integer.toString(i));
			} else {
				String str = "";
				if (i % 3 == 0) {
					str += "Fizz";
				}
				if (i % 5 == 0) {
					str += "Buzz";
				}
				list.add(str);
			}
		}
		return list;

	}

}
