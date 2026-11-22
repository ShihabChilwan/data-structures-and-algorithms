/*
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 *
 * Problem:
 * Given an array nums with n objects colored red, white, or blue
 * (represented by 0, 1 and 2), sort them in-place so that objects of the
 * same color are adjacent, in the order red, white, blue (0s, 1s, 2s).
 * You must not use the library's sort function.
 *
 * Example:
 * Input:  nums = [2, 0, 2, 1, 1, 0]
 * Output: [0, 0, 1, 1, 2, 2]
 *
 * Approach: Dutch National Flag (three pointers), one pass
 *   low  -> next position for a 0
 *   mid  -> current element being checked
 *   high -> next position for a 2
 * Everything before low is 0, everything after high is 2.
 *   nums[mid] == 0 -> swap with low, move low and mid forward
 *   nums[mid] == 1 -> already in place, move mid forward
 *   nums[mid] == 2 -> swap with high, move high back
 *                     (don't move mid: the swapped-in value is unchecked)
 *
 * Time: O(n) | Space: O(1)
 */

import java.util.Arrays;

public class LC0075SortColors {

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC0075SortColors s = new LC0075SortColors();

        int[] a = {2, 0, 2, 1, 1, 0};
        s.sortColors(a);
        System.out.println(Arrays.toString(a)); // [0, 0, 1, 1, 2, 2]

        int[] b = {2, 0, 1};
        s.sortColors(b);
        System.out.println(Arrays.toString(b)); // [0, 1, 2]

        int[] c = {1};
        s.sortColors(c);
        System.out.println(Arrays.toString(c)); // [1]

        int[] d = {2, 2, 0, 0};
        s.sortColors(d);
        System.out.println(Arrays.toString(d)); // [0, 0, 2, 2]
    }
}
