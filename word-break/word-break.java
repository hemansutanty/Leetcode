class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] cache = new Boolean[s.length()];
        return wordBreak(s, set, cache,0);    
    }
    
    public boolean wordBreak(String s, Set<String> set, Boolean[] cache, int startIndex){
        if(s.length()==startIndex)return true;
        if(cache[startIndex]!=null)return cache[startIndex];
        boolean result = false;
        for(int i=startIndex+1;i<=s.length();i++){
            if(!set.contains(s.substring(startIndex,i)))continue;
            if(wordBreak(s, set, cache,i)){
                result = true;break;
            }
        }
        cache[startIndex]=result;
        return result;
    }
}