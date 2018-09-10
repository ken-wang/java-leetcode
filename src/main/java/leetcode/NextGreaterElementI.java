package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int index = 0; index < nums2.length; index++) {
			map.put(nums2[index], index);
		}
		int[] nums = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int index = map.get(nums1[i]);
			nums[i] = -1;
			for (int j = index; j < nums2.length; j++) {
				if (nums1[i] < nums2[j]) {
					nums[i] = nums2[j];
					break;
				}
			}
		}
		return nums;
	}
}
