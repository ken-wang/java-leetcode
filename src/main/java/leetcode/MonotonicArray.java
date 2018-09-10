package leetcode;

public class MonotonicArray {

	public boolean isMonotonic(int[] A) {

		if (A.length == 1) {
			return true;
		}
		
		return isIncreasingMonotonic(A) | isDecreasingMonotonic(A);
	}
	
	private boolean isIncreasingMonotonic(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] > A[i]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isDecreasingMonotonic(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] < A[i]) {
				return false;
			}
		}
		return true;
	}

}
