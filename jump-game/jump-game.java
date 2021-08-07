class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        return canJump(0, nums, cache);
    }
    public boolean canJump(int currentIndex, int[] nums, Boolean[] cache){
        if(currentIndex==nums.length-1)return true;
        if(currentIndex>=nums.length) return false;
        if(cache[currentIndex]!=null) return cache[currentIndex];
        boolean canJumpResult = false;
        for(int i=1;i<=nums[currentIndex];i++){
            if(canJump(currentIndex+i, nums, cache)){canJumpResult = true;break;}
        }
        cache[currentIndex]=canJumpResult;
        return cache[currentIndex];
    }
}