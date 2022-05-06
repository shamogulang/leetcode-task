package cn.oddworld;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */
public class Leetcode53 {

    public static void main(String[] args) {
        int[] ns = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(ns);
        System.out.println(i);
    }

    /**
     * 1、定义dp数组的含义，dp[i]表示以当前元素结尾的最大的子数组和。
     * 2、关系式：dp[i]= max(dp[i-1], dp[i-1] + nums[i])
     * 3、初始值： dp[0] = nums[0]
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int lent = nums.length;
        int[] dp = new int[lent];
        dp[0] = nums[0];

        //-2,1,-3,4,-1,2,1,-5,4
        int max = dp[0];
        for(int i = 1; i< lent;i++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            if(max < dp[i]){
                max = dp[i];
            }
        }

        return max;
    }
}
