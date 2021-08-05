class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequence(text1, text2,0,0, dp);    
    }
    public int longestCommonSubsequence(String text1, String text2, int i, int j, Integer[][] dp){
        if(i==text1.length() || j==text2.length())return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1+longestCommonSubsequence(text1, text2, i+1, j+1, dp);
        }else{
            int skipT2 = longestCommonSubsequence(text1, text2, i, j+1, dp);
            int skipT1 = longestCommonSubsequence(text1, text2, i+1, j, dp);
            dp[i][j]=Math.max(skipT1, skipT2);
        }   
        return dp[i][j];
    }
}