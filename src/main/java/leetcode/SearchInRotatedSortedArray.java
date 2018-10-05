package leetcode;

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {

		if (nums.length == 0) {
			return -1;
		} else if (nums.length == 1) {
			return (target == nums[0]) ? 0 : -1;
		}

		int minIndex = findMinIndex(nums);
		int maxIndex = (nums.length - 1 + minIndex) % nums.length;

		if (target < nums[minIndex] || target > nums[maxIndex]) {
			return -1;
		} else if (target == nums[0]) {
			return 0;
		} else if (target < nums[0]) {
			return search(nums, target, minIndex, nums.length - 1);
		} else {
			return search(nums, target, 0, maxIndex);
		}

	}

	private int search(int[] nums, int target, int start, int end) {
		int index = -1;
		for (int i = start; i <= end; i++) {
			if (target == nums[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	private int findMinIndex(int[] nums) {

		if (nums[0] < nums[nums.length - 1]) {
			return 0;
		} else {

			int min = nums[0];
			int index = nums.length;
			while (min > nums[index - 1]) {
				index--;
				min = nums[index];
			}
			return index;

		}
	}

}
