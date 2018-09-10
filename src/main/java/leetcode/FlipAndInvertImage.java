package leetcode;

public class FlipAndInvertImage {

	public int[][] flipAndInvertImage(int[][] A) {
		return reverse(flip(A));
	}

	private int[][] flip(int[][] A) {

		for (int i = 0; i < A.length; i++) {
			int _length = A[i].length;
			for (int j = 0; j < (_length / 2); j++) {
				int temp = A[i][j];
				A[i][j] = A[i][_length - j - 1];
				A[i][_length - j - 1] = temp;
			}
		}

		return A;
	}

	private int[][] reverse(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = (A[i][j] == 1) ? 0 : 1;
			}
		}
		return A;
	}

}
