package leetcode;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int index = 0;

		for (int value : nums) {
			if (value != val) {
				nums[index++] = value;
			}
		}
		return index;

	}
}
