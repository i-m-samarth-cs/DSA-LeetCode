class Solution {
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
// Ensure nums1 is the smaller array
if (nums1.length > nums2.length) {
int[] temp = nums1;
nums1 = nums2;
nums2 = temp;
}

int m = nums1.length;
int n = nums2.length;
int low = 0, high = m;
while (low <= high) {
int partition1 = (low + high) / 2;
int partition2 = (m + n + 1) / 2 - partition1;
// If partition is 0 it means nothing is there on left side. Use -Infinity for maxLeft1
// If partition is length of input then there is nothing on right side. Use +Infinity for minRight1
double maxLeft1 = (partition1 == 0)? Integer.MIN_VALUE : nums1[partition1 - 1];
double minRight1 = (partition1 == m)? Integer.MAX_VALUE : nums1[partition1];
double maxLeft2 = (partition2 == 0)? Integer.MIN_VALUE : nums2[partition2 - 1];
double minRight2 = (partition2 == n)? Integer.MAX_VALUE : nums2[partition2];
// We have partitioned array at correct place
if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
// We have an even total length
if ((m + n) % 2 == 0) {
return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
} else { // We have an odd total length
return Math.max(maxLeft1, maxLeft2);
}
} else if (maxLeft1 > minRight2) { // We are too far on right side for partition1. Go on left side.
high = partition1 - 1;
} else { // We are too far on left side for partition1. Go on right side.
low = partition1 + 1;
}
}
throw new IllegalArgumentException("Input arrays are not sorted.");
}
}