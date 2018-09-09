package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FourSum {

	class Four {
		int a;
		int b;
		int c;
		int d;

		Four(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public List<Integer> toList() {
			List<Integer> list = new ArrayList<>();
			list.add(a);
			list.add(b);
			list.add(c);
			list.add(d);
			return list;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			result = prime * result + d;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Four other = (Four) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			if (d != other.d)
				return false;
			return true;
		}

	}

	public List<List<Integer>> fourSum(int[] nums, int target) {

		Set<Four> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					for (int l = k + 1; l < nums.length; l++) {
						int value = nums[i] + nums[j] + nums[k] + nums[l];
						if (value == target) {
							int[] four = new int[] { nums[i], nums[j], nums[k], nums[l] };
							Arrays.sort(four);
							set.add(new Four(four[0], four[1], four[2], four[3]));
						}
					}
				}

			}
		}
		return set.stream().map(four -> four.toList()).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		FourSum obj = new FourSum();
		for (List<Integer> list : obj.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0)) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
