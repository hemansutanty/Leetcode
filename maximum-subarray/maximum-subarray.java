class Solution {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar =Integer.MIN_VALUE;
        for(int num:nums){
            maxEndingHere+=num;
            if(maxSoFar<maxEndingHere)maxSoFar =maxEndingHere;
            if(maxEndingHere<0)maxEndingHere=0;
        }
        return maxSoFar;
    }
}