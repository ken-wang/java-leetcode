package leetcode;

import java.util.Arrays;

public class ArrayPartitionI {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			if (nums[i] > nums[i + 1]) {
				sum += nums[i + 1];
			} else {
				sum += nums[i];
			}
		}

		return sum;
	}

}
