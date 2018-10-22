package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> results) {
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				List<Integer> triplet = new ArrayList<>();
				triplet.add(-target);
				triplet.add(nums[left]);
				triplet.add(nums[right]);
				results.add(triplet);

				left++;
				right--;

				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		if (results == null || nums.length < 3) {
			return results;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = nums.length - 1;
			int target = -nums[i];

			twoSum(nums, left, right, target, results);
		}

		return results;
	}

}
