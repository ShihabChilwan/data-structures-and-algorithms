/*
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 *
 * Problem:
 * Given an array nums containing n distinct numbers taken from the range
 * [0, n], return the only number in that range that is missing.
 *
 * Example:
 * Input:  nums = [3, 0, 1]
 * Output: 2
 * Explanation: n = 3, so the range is [0, 3]. 2 is the missing number.
 *
 * Approach: Math (sum formula)
 * The sum of 0..n is n * (n + 1) / 2. Subtract the actual sum of the
 * array from it; whatever is left over is the missing number.
 *
 * Time: O(n) | Space: O(1)
 */

public class LC0268MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return expected - actual;
    }

    public static void main(String[] args) {
        LC0268MissingNumber s = new LC0268MissingNumber();
        System.out.println(s.missingNumber(new int[]{3, 0, 1}));                   // 2
        System.out.println(s.missingNumber(new int[]{0, 1}));                      // 2
        System.out.println(s.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8
        System.out.println(s.missingNumber(new int[]{1}));                         // 0
    }
}
