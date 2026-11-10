/*
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Problem:
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) with the largest sum, and return that sum.
 *
 * Example:
 * Input:  nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: The subarray [4, -1, 2, 1] has the largest sum = 6.
 *
 * Approach: Kadane's Algorithm
 * Walk through the array keeping "current", the best sum of a subarray
 * ending at this index. At each number, either extend the previous
 * subarray or start fresh from this number, whichever is bigger.
 * Track the best "current" seen overall.
 *
 * Time: O(n) | Space: O(1)
 */

public class LC0053MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    public static void main(String[] args) {
        LC0053MaximumSubarray s = new LC0053MaximumSubarray();
        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(s.maxSubArray(new int[]{1}));                            // 1
        System.out.println(s.maxSubArray(new int[]{5, 4, -1, 7, 8}));               // 23
        System.out.println(s.maxSubArray(new int[]{-3, -1, -2}));                   // -1
    }
}
