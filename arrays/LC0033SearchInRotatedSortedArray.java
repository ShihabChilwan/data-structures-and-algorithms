/*
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Problem:
 * An array of unique numbers sorted in ascending order has been rotated
 * at some unknown point, e.g. [0, 1, 2, 4, 5, 6, 7] -> [4, 5, 6, 7, 0, 1, 2].
 * Given the rotated array nums and an integer target, return the index
 * of target, or -1 if it is not in nums.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example:
 * Input:  nums = [4, 5, 6, 7, 0, 1, 2], target = 0
 * Output: 4
 *
 * Approach: Modified Binary Search
 * At any mid, at least one half (left..mid or mid..right) is sorted.
 *   1. Find which half is sorted by comparing nums[left] with nums[mid].
 *   2. If target lies inside that sorted half's range, search there.
 *      Otherwise, search the other half.
 *
 * Time: O(log n) | Space: O(1)
 */

public class LC0033SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // Left half [left..mid] is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half [mid..right] is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC0033SearchInRotatedSortedArray s = new LC0033SearchInRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(s.search(new int[]{1}, 0));                   // -1
        System.out.println(s.search(new int[]{5, 1, 3}, 5));             // 0
        System.out.println(s.search(new int[]{3, 1}, 1));                // 1
    }
}
