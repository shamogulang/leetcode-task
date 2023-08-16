package cn.oddworld;

/**
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Leetcode322 {


    public static void main(String[] args) throws Exception {
        Leetcode322 leetcode322 = new Leetcode322();
        int[] coins = {3,6,8};
        int amount = 90;
        while (true){
            int i = 10;
            leetcode322.coinChange(coins, amount);
            i++;
        }
    }

    /**
     * 1、定义dp数组的含义：dp[i]表示使用coins来i数额的钱，最少使用dp[i]枚coin
     * 2、状态转移方程：dp[i]=min(dp[i-j1],dp[i-j2]...dp[i-jn])+1
     * 3、初始dp[0]=0
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {


        int[]  dp = new int[amount+1];
        dp[0] = 0;

        for(int i = 1; i <= amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length;j++){
                if(i >= coins[j] && dp[i- coins[j]] != Integer.MAX_VALUE && dp[i- coins[j]] + 1 < dp[i]){
                    dp[i] = dp[i -coins[j]] +1;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
