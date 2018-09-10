package leetcode;

public class ReshapeTheMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c) {

		if (r * c != nums.length * nums[0].length) {
			return nums;
		}

		int[] temp = new int[r * c];
		int index = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				temp[index++] = nums[i][j];
			}
		}

		index = 0;
		int[][] reshape = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				reshape[i][j] = temp[index++];
			}
		}
		return reshape;

	}
}
