class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0 || envelopes[0].length==0)return 0;
        int length = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0]==arr2[0])return arr1[1]-arr2[1];
                else return arr1[0]-arr2[0];
            }
        });
        int max = 1;
        int[] dp = new int[envelopes.length+1];
        Arrays.fill(dp,1);
        for(int i=1;i<length;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0] &&
                  envelopes[i][1]>envelopes[j][1] &&
                  1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                }
                if(max<dp[i])max=dp[i];
            }
        }
        return max;
    }
}