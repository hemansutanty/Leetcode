class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return lengthOfLIS(nums, 0, -1, dp);    
    }
    public int lengthOfLIS(int[] nums, int currentIndex, int previousIndex, Integer[][] dp){
        if(currentIndex>=nums.length)return 0;
        if(dp[currentIndex][previousIndex+1]!=null)return dp[currentIndex][previousIndex+1];
        int pickCurrent=0;
        if(previousIndex==-1|| nums[currentIndex]>nums[previousIndex]){
            pickCurrent = 1+lengthOfLIS(nums, currentIndex+1, currentIndex, dp);
        }
        int skipCurrent = lengthOfLIS(nums, currentIndex+1, previousIndex, dp);
        dp[currentIndex][previousIndex+1] = Math.max(pickCurrent, skipCurrent);
        return dp[currentIndex][previousIndex+1];
    }
}