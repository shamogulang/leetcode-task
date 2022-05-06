package cn.oddworld;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class LeetCode64 {


    /**
     * 1、定义数组的含义：假设有m行和n列我们的目的是从左上角走到右下角。那么dp[i][j]就定义为从左上角到右下角的最小路径的和。
     * 则右下角dp[m-1][n-1]即使需要求的答案。
     * 2、找出关系：机器人怎么样才能走到dp[i][j]这里步呢？要么从dp[i-1][j]走过来，或者从dp[i][j-1]走过来。所以
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
     * 3、找出初始值：第一行的dp[0][j] = dp[0][0]+...+dp[0][j]
     * 第一列：dp[i][0]=dp[0][0]+...+dp[i][0]
     * @param grid
     * @return
     */
    public int go(int[][] grid){

        // 这里跟机器人的路径是一样的。不过这里不是选择所有的可能性，而是选最小值。
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp =new int[m][n];

        int rorSum = 0;
        for(int i =0; i<n;i++){
            rorSum = rorSum + grid[0][i];
            dp[0][i] = rorSum;
        }

        int colSum = 0;
        for(int i = 0; i < m;i++){
            colSum = colSum + grid[i][0];
            dp[i][0] = colSum;
        }

        for(int i = 1; i < m;i++){
            for(int j = 1; j < n;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
