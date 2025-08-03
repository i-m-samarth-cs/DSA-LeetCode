class Solution {
    public static int count(int nums[],int num,int si,int ei){
        int count = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i] == num){
                count +=1 ;
            }
        }
        return count;
    }
    public static int majorityElementRec(int nums[],int si,int ei){
        if(si == ei){
            return nums[si];
        }

        int mid = (si + ei) / 2;
        int left = majorityElementRec(nums,si,mid);
        int right = majorityElementRec(nums,mid+1,ei);

        if(left == right){
            return left;
        }

        int l_count = count(nums,left,si,ei);
        int r_count = count(nums,right,si,ei);

        return l_count > r_count ? left : right;
    }
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums,0,nums.length-1);
    }
}