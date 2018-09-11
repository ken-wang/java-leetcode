package leetcode;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {

		if (Integer.MIN_VALUE == dividend && ((long) dividend / (long) divisor) > (long) Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		return dividend / divisor;
	}

}
