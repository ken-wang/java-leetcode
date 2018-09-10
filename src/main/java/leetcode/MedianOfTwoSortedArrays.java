package leetcode;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		
		int median = (nums1.length + nums2.length) / 2;
		int length = nums1.length + nums2.length;
		int[] medians = new int[2];
		
		int x = 0;
		int y = 0;
		for (int i = 0; i <= median; i++) {
			if (x < nums1.length && y < nums2.length) {
				if (nums1[x] < nums2[y]) {
					medians[0] = medians[1];
					medians[1] = nums1[x];
					x++;
				} else {
					medians[0] = medians[1];
					medians[1] = nums2[y];
					y++;
				}
			} else if (x >= nums1.length && y < nums2.length) {
				medians[0] = medians[1];
				medians[1] = nums2[y];
				y++;
			} else if (x < nums1.length && y >= nums2.length) {
				medians[0] = medians[1];
				medians[1] = nums1[x];
				x++;
			}
		}
		if (length == 1) {
			return medians[1];
		} else if (length % 2 == 0) {
			return (double) (medians[0] + medians[1]) / 2;
		} else {
			return medians[1];
		}
		
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int median = (nums1.length + nums2.length) / 2;
		int[] sum = new int[nums1.length + nums2.length];

		int x = 0;
		int y = 0;

		for (int i = 0; i <= median; i++) {
			if (x < nums1.length && y < nums2.length) {
				if (nums1[x] < nums2[y]) {
					sum[i] = nums1[x];
					x++;
				} else {
					sum[i] = nums2[y];
					y++;
				}
			} else if (x >= nums1.length && y < nums2.length) {
				sum[i] = nums2[y];
				y++;
			} else if (x < nums1.length && y >= nums2.length) {
				sum[i] = nums1[x];
				x++;
			}

		}

		if (sum.length == 1) {
			return sum[0];
		} else if (sum.length == 2) {
			return (double) (sum[0] + sum[1]) / 2;
		} else {
			return (sum.length % 2 == 0) ? (double) (sum[median] + sum[median - 1]) / 2 : sum[median];
		}
	}

}
