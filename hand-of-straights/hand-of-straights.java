class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h:hand){
            map.put(h, map.getOrDefault(h,0)+1);
        }
        
        while(map.size()>0){
            int minValue = map.firstKey();
            for(int i=minValue;i<minValue+groupSize;i++){
                if(!map.containsKey(i))return false;
                if(map.get(i)==1)map.remove(i);
                else map.put(i, map.get(i)-1);
            }
        }
        return true;
    }
    
}