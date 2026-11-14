/*
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Problem:
 * Given an integer array nums, find a contiguous non-empty subarray that
 * has the largest product, and return that product.
 *
 * Example:
 * Input:  nums = [2, 3, -2, 4]
 * Output: 6
 * Explanation: The subarray [2, 3] has the largest product = 6.
 *
 * Approach: Kadane's Algorithm, tracking both max AND min
 * Like Maximum Subarray (LC0053), but with a twist: a negative number
 * flips signs. The smallest (most negative) product so far can become
 * the largest after multiplying by a negative number.
 * So at each index, keep both:
 *   maxHere = largest product of a subarray ending here
 *   minHere = smallest product of a subarray ending here
 * Each is the max/min of: the number alone, num * maxHere, num * minHere.
 *
 * Time: O(n) | Space: O(1)
 */

public class LC0152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int best = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int a = num * maxHere;
            int b = num * minHere;

            maxHere = Math.max(num, Math.max(a, b));
            minHere = Math.min(num, Math.min(a, b));

            best = Math.max(best, maxHere);
        }
        return best;
    }

    public static void main(String[] args) {
        LC0152MaximumProductSubarray s = new LC0152MaximumProductSubarray();
        System.out.println(s.maxProduct(new int[]{2, 3, -2, 4}));  // 6
        System.out.println(s.maxProduct(new int[]{-2, 0, -1}));    // 0
        System.out.println(s.maxProduct(new int[]{-2, 3, -4}));    // 24
        System.out.println(s.maxProduct(new int[]{-2}));           // -2
    }
}
