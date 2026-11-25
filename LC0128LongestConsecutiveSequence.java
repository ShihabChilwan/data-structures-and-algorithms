/*
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Problem:
 * Given an unsorted array of integers nums, return the length of the
 * longest sequence of consecutive numbers (like 1, 2, 3, 4).
 * The numbers can be anywhere in the array.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example:
 * Input:  nums = [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive sequence is [1, 2, 3, 4].
 *
 * Approach: Hash Set, only count from the START of each sequence
 * 1. Put every number in a set for O(1) lookups.
 * 2. For each number, check if (num - 1) is in the set.
 *      - If yes, num is NOT the start of a sequence, skip it.
 *      - If no, num IS a start: count upward (num + 1, num + 2, ...)
 *        while the next number exists.
 * 3. Track the longest length found.
 * Each number is counted at most once inside a sequence, so it's O(n).
 *
 * Time: O(n) | Space: O(n)
 */

import java.util.HashSet;
import java.util.Set;

public class LC0128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            // Only start counting from the first number of a sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LC0128LongestConsecutiveSequence s = new LC0128LongestConsecutiveSequence();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));          // 4
        System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));  // 9
        System.out.println(s.longestConsecutive(new int[]{1, 0, 1, 2}));                    // 3
        System.out.println(s.longestConsecutive(new int[]{}));                              // 0
    }
}
