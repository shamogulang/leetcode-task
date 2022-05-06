package cn.oddworld.dynamic;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class FrogJump {


    public static void main(String[] args) {
        // 第n（n>2）级的阶梯,青蛙会从第n-1或者n-2级跳上去。
        // 所以n-1级别的可能性，加上最后一级阶梯的跳跃，还有n-2级的可能性，加上最后一次二级的跳跃。所以
        // f(n) = f(n-1) + f(n-2)  n > 2



    }

    public int f(int n){
        if(n == 1 || n == 2){
            return n;
        }
        int[] dp = new int[n];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i <= n; i--){

            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
