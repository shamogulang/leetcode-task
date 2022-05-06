package cn.oddworld;

/**
 *
 */
public class Leetcode72 {


    /**
     * 1、定义数组的含义，dp[i][j]的含义为：当字符串word1长度为i，字符串的长度为j是，将word1转成word2所需要的最少操作数
     * 2、找关系：如果word1[i]与word2[j]相等，那么不需要任何操作，dp[i][j]=dp[i-1][j-1]
     *    如果不等:  如果将word1删除一个字符，dp[i][j] = dp[i-1][j] + 1
     *    如果word1替换一个字符：dp[i][j] = dp[i-1][j-1] + 1
     *    如果word1增加一个字符：dp[i][j] = dp[i][j-1] + 1
     *    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * 3、初始值：如果word1为""时，只能插入了。
     *    如果word2为"",只能删除了。
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if(n==0 && m==0){
            return 0;
        }

        int[][] dp = new int[m+1][n+1];
        // 如果word1=""
        for(int i = 1; i <= n; i++){
            dp[0][i] = dp[0][i-1]+1;
        }

        for(int i = 1; i <= m; i++){
            dp[i][0] = dp[i-1][0] + 1;
        }

        if(m == 0){
            return dp[0][n];
        }

        if(n == 0){
            return dp[m][0];
        }

        for(int i = 1; i <= m;i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                   dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),  dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
