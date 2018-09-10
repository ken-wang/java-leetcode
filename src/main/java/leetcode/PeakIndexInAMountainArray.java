package leetcode;

public class PeakIndexInAMountainArray {
	public int peakIndexInMountainArray(int[] A) {

		int max = -1;
		int index = -1;
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
				index = i;
			}
		}

		return index;

	}

}
