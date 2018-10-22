package leetcode;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		} 
		int reverse = 0;
		int temp = x;

		for (int i = temp; i > 0; i = i / 10) {
			reverse = reverse * 10 + i % 10;
		}
		return reverse == x;

	}

}
