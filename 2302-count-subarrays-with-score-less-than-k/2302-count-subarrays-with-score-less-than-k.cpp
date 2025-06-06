class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        int n = nums.size(), left = 0, sum = 0, count = 0;
        
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while ((long long)sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        
        return count;
    }
};