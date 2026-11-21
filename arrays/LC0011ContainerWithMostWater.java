/*
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Problem:
 * You are given an integer array height of length n. There are n vertical
 * lines; line i goes from (i, 0) to (i, height[i]).
 * Pick two lines that, together with the x-axis, form a container holding
 * the most water. Return the maximum amount of water it can store.
 * (The container cannot be tilted.)
 *
 * Example:
 * Input:  height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
 * Output: 49
 * Explanation: Lines at index 1 (height 8) and index 8 (height 7):
 *              width = 8 - 1 = 7, height = min(8, 7) = 7, area = 49.
 *
 * Approach: Two Pointers (start wide, move the shorter line)
 * Area = (right - left) * min(height[left], height[right]).
 * Start with the widest container. To possibly find a bigger area as the
 * width shrinks, we need a taller line, so always move the pointer at
 * the SHORTER line inward. Moving the taller one can never help, because
 * the height is still capped by the shorter line while width drops.
 *
 * Time: O(n) | Space: O(1)
 */

public class LC0011ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int best = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            best = Math.max(best, width * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        LC0011ContainerWithMostWater s = new LC0011ContainerWithMostWater();
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(s.maxArea(new int[]{1, 1}));                      // 1
        System.out.println(s.maxArea(new int[]{4, 3, 2, 1, 4}));             // 16
        System.out.println(s.maxArea(new int[]{1, 2, 1}));                   // 2
    }
}
