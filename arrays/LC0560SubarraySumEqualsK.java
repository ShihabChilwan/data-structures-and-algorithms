/*
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Problem:
 * Given an integer array nums and an integer k, return the total number
 * of contiguous subarrays whose sum equals k.
 * (nums can contain negative numbers.)
 *
 * Example:
 * Input:  nums = [1, 2, 3], k = 3
 * Output: 2
 * Explanation: [1, 2] and [3] both sum to 3.
 *
 * Approach: Prefix Sum + Hash Map
 * Let prefix = sum of nums[0..i].
 * A subarray (j+1..i) sums to k when prefix_i - prefix_j == k,
 * i.e. when an earlier prefix equal to (prefix_i - k) exists.
 * So keep a map: prefix sum -> how many times we've seen it.
 * At each index, add count[prefix - k] to the answer, then record prefix.
 * Start with count[0] = 1 so subarrays starting at index 0 are counted.
 *
 * (Sliding window does NOT work here because of negative numbers.)
 *
 * Time: O(n) | Space: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class LC0560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int prefix = 0;
        int result = 0;

        for (int num : nums) {
            prefix += num;
            result += count.getOrDefault(prefix - k, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LC0560SubarraySumEqualsK s = new LC0560SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));        // 2
        System.out.println(s.subarraySum(new int[]{1, 2, 3}, 3));        // 2
        System.out.println(s.subarraySum(new int[]{1, -1, 0}, 0));       // 3
        System.out.println(s.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7)); // 4
    }
}
