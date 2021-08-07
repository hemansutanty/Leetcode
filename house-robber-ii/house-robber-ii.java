class Solution {
    public int rob(int[] nums) {
        Integer[] cache1 = new Integer[nums.length];
        Integer[] cache2 = new Integer[nums.length];
        if(nums.length==1)return nums[0];
        int[] set1 = new int[nums.length-1];
        int[] set2 = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            set1[i]=nums[i];
        }
        for(int i=1;i<nums.length;i++){
            set2[i-1]=nums[i];
        }
        System.out.println(rob(0, set2, cache2));
        return Math.max(rob(0, set1, cache1), rob(0, set2, cache2));    
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