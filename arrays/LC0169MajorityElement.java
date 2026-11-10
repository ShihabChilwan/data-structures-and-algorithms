/*
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 *
 * Problem:
 * Given an array nums of size n, return the majority element: the element
 * that appears more than n / 2 times. You may assume it always exists.
 *
 * Example:
 * Input:  nums = [2, 2, 1, 1, 1, 2, 2]
 * Output: 2
 *
 * Approach: Boyer-Moore Voting Algorithm
 * Keep a candidate and a count. When count is 0, pick the current number
 * as the new candidate. Add 1 if the number matches the candidate,
 * subtract 1 otherwise. The majority element appears more than half the
 * time, so it survives all the cancelling and ends as the candidate.
 *
 * Time: O(n) | Space: O(1)
 */

public class LC0169MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        LC0169MajorityElement s = new LC0169MajorityElement();
        System.out.println(s.majorityElement(new int[]{3, 2, 3}));             // 3
        System.out.println(s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
        System.out.println(s.majorityElement(new int[]{7}));                   // 7
    }
}
