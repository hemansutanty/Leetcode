class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int j=i+1, k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    set.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0)j++;
                else k--;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }
}