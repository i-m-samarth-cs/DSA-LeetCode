class Solution {
    public String triangleType(int[] nums) {
       for(int i=0;i<nums.length;i++)
       {
        for(int j=i+1;j<nums.length;j++)
        {
                if(nums[i]==nums[j])
                {
                    return "equilateral";
                
            }
            if(nums[i] + nums[j] > nums[j+1])
            {
                return "scalene";
            }
            if(nums[i] != nums[j])
            {
                return "isosceles";
            }
        }
       } 
       return "none";
    }
}