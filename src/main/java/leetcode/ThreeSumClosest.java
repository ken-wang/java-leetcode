package leetcode;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {

		int minDistance = Integer.MAX_VALUE;
		int minSum = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (Math.abs(minDistance) > Math.abs(sum - target)) {
						minDistance = sum - target;
						minSum = sum;
					}
				}
			}
		}
		return minSum;
	}

}
