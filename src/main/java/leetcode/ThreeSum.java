package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

	class Three {
		int a;
		int b;
		int c;

		Three(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public List<Integer> toList() {
			List<Integer> list = new ArrayList<>();
			list.add(a);
			list.add(b);
			list.add(c);
			return list;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
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
			Three other = (Three) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}

	}

	public List<List<Integer>> threeSum(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Three> set = new HashSet<>();
		List<Integer> positives = new ArrayList<>();
		List<Integer> negatives = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				positives.add(nums[i]);
			} else {
				negatives.add(nums[i]);
			}
			int count = 0;
			if (map.containsKey(nums[i])) {
				count = map.get(nums[i]);
			}
			map.put(nums[i], ++count);
		}

		for (int i = 0; i < positives.size(); i++) {
			for (int j = i + 1; j < positives.size(); j++) {
				int value = positives.get(i) + positives.get(j);
				if (map.containsKey(-value)) {
					int[] three = new int[] { positives.get(i), positives.get(j), -value };
					Arrays.sort(three);
					set.add(new Three(three[0], three[1], three[2]));
				}
			}
		}
		for (int i = 0; i < negatives.size(); i++) {
			for (int j = i + 1; j < negatives.size(); j++) {
				int value = negatives.get(i) + negatives.get(j);
				if (map.containsKey(-value)) {
					int[] three = new int[] { negatives.get(i), negatives.get(j), -value };
					Arrays.sort(three);
					set.add(new Three(three[0], three[1], three[2]));
				}
			}
		}
		if (map.containsKey(0) && map.get(0) < 3) {
			set.remove(new Three(0, 0, 0));
		}

		return set.stream().map(three -> three.toList()).collect(Collectors.toList());
	}

}
