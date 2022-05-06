package cn.oddworld;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers
 * in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 */
public class Leetcode16 {


    public static void main(String[] args) {

        int[] m = {-1,2,1,-4};
        int i = threeSumClosest(m, 1);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {

        int closet = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        boolean jumpOut = false;
        for(int i =0; i < nums.length && !jumpOut; i++){
            int fixed = nums[i];
            int l = i+1;
            int r = nums.length-1;
            while (l < r){
                int curClose =  fixed + nums[l] + nums[r] - target;
                if(curClose == 0){
                    jumpOut = true;
                    closet = curClose;
                    result = fixed + nums[l] + nums[r];
                    break;
                }else if(curClose < 0){
                    if(closet > -curClose){
                        closet = -curClose;
                        result = fixed + nums[l] + nums[r];
                    }
                    l++;
                }else {
                    if(closet > curClose){
                        closet = curClose;
                        result = fixed + nums[l] + nums[r];
                    }
                    r--;
                }
            }
        }
        return result;
    }
}
