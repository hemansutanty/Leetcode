class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0)return 0;
        Integer[] cache = new Integer[s.length()+1];
        return numDecodings(0, s, cache);
    }
    public int numDecodings(int currentIndex, String s, Integer[] cache){
        if(currentIndex==s.length()) return 1; 
        if(s.charAt(currentIndex)=='0')return 0;
        if(cache[currentIndex]!=null) return cache[currentIndex];
        int numDecodings = numDecodings(currentIndex+1, s, cache);
        if (currentIndex+1<s.length() && (s.charAt(currentIndex)=='1' || (s.charAt(currentIndex)=='2') && s.charAt(currentIndex+1)<'7')){
            numDecodings += numDecodings(currentIndex+2, s, cache);  
        }
        cache[currentIndex]=numDecodings;
        return cache[currentIndex];
    }
}