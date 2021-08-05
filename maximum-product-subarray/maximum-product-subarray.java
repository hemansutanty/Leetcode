class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0)return 0;
        int maxSoFar,minSoFar,result;
        maxSoFar=minSoFar=result=nums[0];
        int tempMax;
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            tempMax=Math.max(num, Math.max(num*maxSoFar,num*minSoFar));
            minSoFar=Math.min(num, Math.min(num*maxSoFar,num*minSoFar));
            maxSoFar = tempMax;
            result = Math.max(result,maxSoFar);
        }
        return result;
    }
}