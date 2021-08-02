class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k !=0)return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for( int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        while(map.size()>0){
            int minNum = map.firstKey();
            for(int num=minNum; num<minNum+k; num++){
                if(!map.containsKey(num))return false;
                if(map.get(num)==1)map.remove(num);
                else map.put(num, map.get(num)-1);
            }
        }
        return true;
    }
}