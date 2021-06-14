class Solution {
    public int maximumBeauty(int[] flowers) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int i =0;i<flowers.length;i++){
            if(sumMap.containsKey(flowers[i])){
                result = Math.max(result, sum-sumMap.get(flowers[i])+2*flowers[i]);
            }
            if(flowers[i]>0){
                sum+=flowers[i];
            }
            if(!sumMap.containsKey(flowers[i])){
                sumMap.put(flowers[i], sum);
            }
        }
        return result;
    }
}