package cn.oddworld;

import java.util.*;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 */
public class Leetcode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        Set<List<Integer>>  res = new HashSet<List<Integer>>();
        for(int i =0; i< nums.length;i++){
            int fixOne = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                int fixTwo = nums[j];
                int l = j +1;
                int r = nums.length -1;
                while (l < r){
                    if(fixOne + fixTwo + nums[l] + nums[r] == target){
                        res.add(Arrays.asList(fixOne, fixTwo, nums[l], nums[r]));
                        l++;
                        r--;
                    }else if(fixOne + fixTwo + nums[l] + nums[r] < target){
                        l++;
                    }else {
                        r--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>(res);
        return result;
    }
}
