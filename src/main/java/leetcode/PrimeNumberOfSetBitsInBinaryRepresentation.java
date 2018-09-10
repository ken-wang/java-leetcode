package leetcode;

public class PrimeNumberOfSetBitsInBinaryRepresentation {

	public int countPrimeSetBits(int L, int R) {
		int count = 0;
		for (int i = L; i <= R; i++) {
			int n = count(i);
			if (isPrime(n)) {
				System.out.println(String.format("n:%d count:%d", i, n));
				count++;
			}
		}
		return count;
	}

	private boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private int count(int n) {
		String binary = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

}
