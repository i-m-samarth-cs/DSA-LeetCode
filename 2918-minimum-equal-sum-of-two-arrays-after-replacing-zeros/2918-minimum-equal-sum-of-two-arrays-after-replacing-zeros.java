class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long z1 = 0, z2 = 0;
        for (int x : nums1) if (x == 0) z1++;
        for (int x : nums2) if (x == 0) z2++;
        long s1 = z1, s2 = z2;
        for (int x : nums1) s1 += x;
        for (int x : nums2) s2 += x;
        if ((s1 < s2 && z1 == 0) || (s2 < s1 && z2 == 0)) return -1;
        return Math.max(s1, s2);
    }
}