class Solution {
    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int maxRepeatLetterCount = 0, maxLength=0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int windowEnd =0; windowEnd<s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0)+1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, freqMap.get(rightChar));
            
            /*After getting maxRepeatLettercount we check if in this window-the maxRepeatLetter count is greater than k,
                then we gotta shrink the window */
            if(windowEnd-windowStart+1-maxRepeatLetterCount>k){
                char leftChar = s.charAt(windowStart);
                freqMap.put(leftChar, freqMap.get(leftChar)-1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
            
        }
        return maxLength;
    }
}