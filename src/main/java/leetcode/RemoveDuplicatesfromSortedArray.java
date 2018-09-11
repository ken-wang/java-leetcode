package leetcode;

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length < 1) {
			return 0;
		} else if (nums.length == 1) {
			return 1;
		}
		
		int above = nums[0];
		int count = 1;
		
		for (int i = 1; i < nums.length; i++) {
			if (above != nums[i]) {
				nums[count] = nums[i];
				count++;
			}
			
			above = nums[i];
		}
		return count;

	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray obj = new RemoveDuplicatesfromSortedArray();
		System.out.println(obj.removeDuplicates(new int[] { 0, 1, 2, 3, 4, 5 }));
		System.out.println(obj.removeDuplicates(new int[] { 0, 1, 1, 2, 2, 3 }));
		System.out.println(obj.removeDuplicates(new int[] { 0, 1, 1, 2, 2, 3, 4, 5 }));
	}
}
