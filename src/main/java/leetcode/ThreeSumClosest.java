package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) {
			return -1;
		}
		if (nums.length == 3) {
			return nums[0] + nums[1] + nums[2];
		}

		Arrays.sort(nums);

		int smallestDiff = Integer.MAX_VALUE;
		int closestSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int currentSum = nums[i] + nums[left] + nums[right];
				int currentDiff = Math.abs(currentSum - target);
				if (currentDiff == 0) {
					return target;
				}

				if (currentDiff < smallestDiff) {
					smallestDiff = currentDiff;
					closestSum = currentSum;
				}

				if (currentSum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return closestSum;
	}

}
