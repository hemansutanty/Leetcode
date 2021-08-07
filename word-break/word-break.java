class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, Boolean> cache = new HashMap<>();
        return wordBreak(s, set, cache);    
    }
    
    public boolean wordBreak(String s, Set<String> set, Map<String, Boolean> cache){
        if(s.length()==0)return true;
        if(cache.containsKey(s))return cache.get(s);
        for(int i=1;i<=s.length();i++){
            if(set.contains(s.substring(0,i)) && wordBreak(s.substring(i), set, cache)){
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s,false);
        return false;
    }
}