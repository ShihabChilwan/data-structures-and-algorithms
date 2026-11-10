/*
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Problem:
 * You are given two sorted arrays nums1 and nums2, and integers m and n,
 * the number of real elements in each. nums1 has length m + n, with the
 * last n slots set to 0 as empty space. Merge nums2 into nums1 so that
 * nums1 becomes one sorted array. Do it in place; return nothing.
 *
 * Example:
 * Input:  nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
 * Output: nums1 = [1, 2, 2, 3, 5, 6]
 *
 * Approach: Three pointers, filling from the back
 * The empty space is at the end of nums1, so compare the largest
 * remaining elements of both arrays and place the bigger one at the
 * back. This never overwrites a number we still need.
 *
 * Time: O(m + n) | Space: O(1)
 */

import java.util.Arrays;

public class LC0088MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          // last real element in nums1
        int j = n - 1;          // last element in nums2
        int k = m + n - 1;      // position to fill in nums1

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        LC0088MergeSortedArray s = new LC0088MergeSortedArray();

        int[] a1 = {1, 2, 3, 0, 0, 0};
        s.merge(a1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(a1)); // [1, 2, 2, 3, 5, 6]

        int[] a2 = {1};
        s.merge(a2, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(a2)); // [1]

        int[] a3 = {0};
        s.merge(a3, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(a3)); // [1]
    }
}
