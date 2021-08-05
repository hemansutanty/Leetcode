class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        return coinChange(coins, amount, dp);
    }
    
    public int coinChange(int[] coins, int amount, Map<Integer, Integer> dp){
        if(amount<0 )return -1;
        if(amount<1)return 0;
        if(dp.containsKey(amount)) return dp.get(amount);
        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins ){
            int result = coinChange(coins, amount-coin, dp);
            if(result>=0 && result < minCoins){
                minCoins = 1+result;
                dp.put(amount, minCoins);
            }
        }
        dp.put(amount,minCoins==Integer.MAX_VALUE?-1:minCoins);
        return dp.get(amount);
    }
}