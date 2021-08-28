class Solution {
    int lo, maxLen;
    public String longestPalindrome(String s) {
        if(s.length()<2)return s;
        for(int i =0;i<s.length();i++){
            extendPalindrome(s, i,i); // odd length;
            extendPalindrome(s, i, i+1); // evenlength
        }
        return s.substring(lo,lo+maxLen);
    }
    public void extendPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--; right++;
        }
        if(maxLen< right-left-1){
            lo = left+1;
            maxLen = right-left-1;
        }
    }
}