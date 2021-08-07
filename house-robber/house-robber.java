class Solution {
    public int rob(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        return rob(0, nums, cache);    
    }
    public int rob(int currentIndex, int[] nums, Integer[] cache){
        if(currentIndex>=nums.length)return 0;
        if(cache[currentIndex]!=null) return cache[currentIndex];
        int robCurrentHouse = nums[currentIndex]+rob(currentIndex+2, nums, cache);
        int skipCurrentHouse = rob(currentIndex+1,nums, cache); 
        cache[currentIndex] = Math.max(robCurrentHouse, skipCurrentHouse);
        return cache[currentIndex];
    }
}