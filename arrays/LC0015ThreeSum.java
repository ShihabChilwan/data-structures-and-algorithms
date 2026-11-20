/*
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Problem:
 * Given an integer array nums, return all unique triplets
 * [nums[i], nums[j], nums[k]] such that i, j, k are different indices
 * and nums[i] + nums[j] + nums[k] == 0.
 * The answer must not contain duplicate triplets.
 *
 * Example:
 * Input:  nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * Approach: Sort + Two Pointers
 * 1. Sort the array.
 * 2. Fix one number nums[i]. Now find two numbers in nums[i+1..end]
 *    that sum to -nums[i] (a two-sum on a sorted array).
 * 3. Use left/right pointers:
 *      sum < 0  -> need a bigger sum, move left forward
 *      sum > 0  -> need a smaller sum, move right backward
 *      sum == 0 -> record triplet, move both pointers
 * 4. Skip duplicate values (for i, left and right) so no triplet repeats.
 *
 * Time: O(n^2) | Space: O(1) extra (ignoring sort and output)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0015ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Smallest number is positive -> no triplet can sum to 0
            if (nums[i] > 0) {
                break;
            }
            // Skip duplicate values for the fixed number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicate values for left and right
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC0015ThreeSum s = new LC0015ThreeSum();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(s.threeSum(new int[]{0, 1, 1}));             // []
        System.out.println(s.threeSum(new int[]{0, 0, 0, 0}));          // [[0, 0, 0]]
        System.out.println(s.threeSum(new int[]{-2, 0, 0, 2, 2}));      // [[-2, 0, 2]]
    }
}
