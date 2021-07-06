class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            if(map.containsKey(wordsDict[i])){
                map.get(wordsDict[i]).add(i);
            }else{
                map.put(wordsDict[i], new ArrayList<>());
                map.get(wordsDict[i]).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> index1List = map.get(word1);
        List<Integer> index2List = map.get(word2);
        int result = Integer.MAX_VALUE;
        for(int i=0,j=0;i<index1List.size() && j<index2List.size();){
            int index1 = index1List.get(i);
            int index2 = index2List.get(j);
            
            //this logic squeezes the minimum range since in map we are keeping the indexes in sorted order.
            if(index1<index2){
                result=Math.min(result, index2-index1);
                i++;
            }else{
                result=Math.min(result, index1-index2);
                j++;
            }
        }
        return result;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */