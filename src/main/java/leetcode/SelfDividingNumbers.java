package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SelfDividingNumbers {

	public List<Integer> selfDividingNumbers(int left, int right) {

		List<Integer> list = new ArrayList<>();

		for (int i = left; i <= right; i++) {
			if (isSelfDividingNumbers(i)) {
				list.add(i);
			}
		}

		return list;
	}

	private boolean isSelfDividingNumbers(int number) {

		for (char c : Integer.toString(number).toCharArray()) {
			int divide = Integer.parseInt(Character.toString(c));
			if (divide == 0)
				return false;
			if (number % divide != 0) {
				return false;
			}
		}

		return true;
	}

}
