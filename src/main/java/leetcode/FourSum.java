package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();

		if (nums == null)
			return ans;
		int len = nums.length;
		if (len < 4)
			return ans;
		if (len == 4) {
			if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
				List<Integer> list = new ArrayList<>();
				list.add(nums[0]);
				list.add(nums[1]);
				list.add(nums[2]);
				list.add(nums[3]);
				ans.add(list);
			}
			return ans;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
				break;
			if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
				continue;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
					break;
				if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target)
					continue;
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
						right--;
					} else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
						left++;
					} else {
						ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						left++;
						right--;
					}
				}
			}
		}
		return ans;
	}
}
