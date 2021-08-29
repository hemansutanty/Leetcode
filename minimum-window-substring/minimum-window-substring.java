class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: t.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        int windowStart =0, minLength = s.length()+1, subStrStart = 0, matched=0;
        for(int windowEnd = 0; windowEnd<s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            if(freqMap.containsKey(rightChar)){
                freqMap.put(rightChar, freqMap.get(rightChar)-1);
                if(freqMap.get(rightChar)>=0)matched++;
            }
            
            
            while(matched==t.length()){
                if(minLength>windowEnd-windowStart+1){
                    minLength=windowEnd-windowStart+1;
                    subStrStart = windowStart;
                }
            
                char leftChar = s.charAt(windowStart++);
                if(freqMap.containsKey(leftChar)){
                    if(freqMap.get(leftChar)==0)matched--;
                    freqMap.put(leftChar,freqMap.get(leftChar)+1);
                }
            }
        }
        
        return minLength >s.length()?"":s.substring(subStrStart,subStrStart+minLength);
    }
}