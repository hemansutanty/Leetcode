class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
            char ch = s.charAt(windowEnd);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
            while(freqMap.size()>k){
                char leftChar = s.charAt(windowStart);
                freqMap.put(leftChar, freqMap.get(leftChar)-1);
                if(freqMap.get(leftChar)==0)freqMap.remove(leftChar);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
}