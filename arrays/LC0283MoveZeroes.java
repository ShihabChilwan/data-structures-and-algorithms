/*
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 *
 * Approach: Two pointers (read / write)
 * Time: O(n) | Space: O(1)
 */

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int write = 0;
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                int temp = nums[write];
                nums[write] = nums[read];
                nums[read] = temp;
                write++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes s = new MoveZeroes();

        int[] nums1 = {0, 1, 0, 3, 12};
        s.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1)); // [1, 3, 12, 0, 0]

        int[] nums2 = {0};
        s.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2)); // [0]

        int[] nums3 = {1, 2, 3};
        s.moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 2, 3]
    }
}
