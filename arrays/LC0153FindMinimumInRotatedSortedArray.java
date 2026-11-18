/*
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Problem:
 * An array of unique numbers sorted in ascending order has been rotated
 * some number of times. For example, [0, 1, 2, 4, 5, 6, 7] might become
 * [4, 5, 6, 7, 0, 1, 2]. Return the minimum element.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example:
 * Input:  nums = [3, 4, 5, 1, 2]
 * Output: 1
 *
 * Approach: Binary Search
 * Compare the middle element with the rightmost element:
 *   - nums[mid] > nums[right]: the drop (the minimum) is to the RIGHT
 *     of mid, so move left = mid + 1.
 *   - otherwise: mid..right is sorted, so the minimum is mid or to its
 *     LEFT, so move right = mid.
 * When left == right, that index holds the minimum.
 *
 * Time: O(log n) | Space: O(1)
 */

public class LC0153FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LC0153FindMinimumInRotatedSortedArray s = new LC0153FindMinimumInRotatedSortedArray();
        System.out.println(s.findMin(new int[]{3, 4, 5, 1, 2}));          // 1
        System.out.println(s.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));    // 0
        System.out.println(s.findMin(new int[]{11, 13, 15, 17}));         // 11
        System.out.println(s.findMin(new int[]{2, 1}));                   // 1
    }
}
