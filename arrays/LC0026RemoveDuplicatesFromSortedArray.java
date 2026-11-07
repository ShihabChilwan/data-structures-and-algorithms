/*
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Problem:
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place so each unique element appears only once, keeping
 * the original order. Return k, the number of unique elements. The first
 * k elements of nums must hold the unique values.
 *
 * Example:
 * Input:  nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
 * Output: 5, nums = [0, 1, 2, 3, 4, _, _, _, _, _]
 *
 * Approach: Two pointers (read / write)
 * Because the array is sorted, duplicates sit next to each other.
 * "write" marks where the next unique value goes. When nums[read]
 * differs from the last unique value kept, copy it to nums[write].
 *
 * Time: O(n) | Space: O(1)
 */

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();

        int[] nums1 = {1, 1, 2};
        int k1 = s.removeDuplicates(nums1);
        System.out.println(k1 + " " + Arrays.toString(Arrays.copyOf(nums1, k1))); // 2 [1, 2]

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = s.removeDuplicates(nums2);
        System.out.println(k2 + " " + Arrays.toString(Arrays.copyOf(nums2, k2))); // 5 [0, 1, 2, 3, 4]

        int[] nums3 = {7};
        int k3 = s.removeDuplicates(nums3);
        System.out.println(k3 + " " + Arrays.toString(Arrays.copyOf(nums3, k3))); // 1 [7]
    }
}
