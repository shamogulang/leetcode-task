package cn.oddworld;

public class Leetcode33 {

    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * All values of nums are unique.
     * nums is an ascending array that is possibly rotated.
     * -104 <= target <= 104
     */

    public static void main(String[] args) {
        Leetcode33 leetcode33 = new Leetcode33();
        //Input: nums = [4,5,6,7,0,1,2], target = 0
        /**
         * [4,5,6,7,0,1,2]
         * 5
         */
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        int search = leetcode33.search(nums, target);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        return binarySearch(left, right, nums, target);
    }

    public int binarySearch(int left, int right, int[] nums, int target){

        if(left > right){
            return -1 ;
        }

        if(nums[left] == target){

            return left;
        }

        if(nums[right] == target){

            return right;
        }

        int mid = (left + right) / 2;

        if(nums[mid] == target){
            return mid;
        }


        if(left == right){

            return -1;
        }

        if(nums[left] < nums[mid]){
            if(nums[left] < target && nums[mid] > target){
                return binarySearch(left+1, mid-1, nums, target);
            }else {
                return binarySearch(mid+1, right-1, nums, target);
            }
        }else {

            if(nums[mid] < target && nums[right] > target){
                return binarySearch(mid+1, right-1, nums, target);
            }else {
                return binarySearch(left+1, mid-1, nums, target);

            }
        }
    }

}
