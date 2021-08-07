class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] cache = new Integer[target+1];
        return combinationSum4(nums, target, cache);
    }
    public int combinationSum4(int[] nums, int target, Integer[] cache){
        if(target==0) return 1;
        if(cache[target]!=null)return cache[target];
        int pickWays = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                pickWays += combinationSum4(nums, target-nums[i], cache);
            }
        }
        cache[target]=pickWays;
        return cache[target];
    }
}