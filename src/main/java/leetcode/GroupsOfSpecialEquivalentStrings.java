package leetcode;

import java.util.HashSet;
import java.util.Set;

public class GroupsOfSpecialEquivalentStrings {

	static class Weight {
		int val1;
		int val2;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + val1;
			result = prime * result + val2;
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
			Weight other = (Weight) obj;
			if (val1 != other.val1)
				return false;
			if (val2 != other.val2)
				return false;
			return true;
		}
	}
	
	public int numSpecialEquivGroups(String[] A) {

		Set<Weight> set = new HashSet<>();
		for (String a : A) {
			char[] chars = a.toCharArray();
			Weight w = new Weight();
			for (int i = 0; i < chars.length; i++) {
				if (i % 2 == 1) {
					w.val1 += ((int)chars[i]) * ((int)chars[i]); 
				} else {
					w.val2 += ((int)chars[i]) * ((int)chars[i]);
				}
			}
			set.add(w);
		}

		return set.size();
	}

}
