package cn.oddworld;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Leetcode15 {

    public List<List<Integer>> threeSum(int[] nums) {

        // 从小到大排序
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<List<Integer>>();
        for(int i = 0; i < nums.length; i++){

            int fixedElem = nums[i];

            int l = i+1;
            int r = nums.length-1;

            while (l < r){
                if(fixedElem + nums[l] + nums[r] == 0){
                    res.add(Arrays.asList(fixedElem, nums[l], nums[r]));
                    l++;
                    r--;
                }else if(fixedElem + nums[l] + nums[r] < 0){
                    l++;
                }else {
                    r--;
                }
            }
        }

        List<List<Integer>> rs = new ArrayList<List<Integer>>(res);
        return  rs;
    }
}
