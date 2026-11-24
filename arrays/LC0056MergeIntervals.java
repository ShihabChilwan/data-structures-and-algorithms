/*
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Problem:
 * Given an array of intervals where intervals[i] = [start, end], merge all
 * overlapping intervals and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 *
 * Example:
 * Input:  intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
 * Output: [[1, 6], [8, 10], [15, 18]]
 * Explanation: [1, 3] and [2, 6] overlap, so they merge into [1, 6].
 *
 * Approach: Sort by start, then merge in one pass
 * 1. Sort intervals by their start value.
 * 2. Walk through them, keeping the last merged interval:
 *      - If the current interval starts <= last merged end, they overlap:
 *        extend the last merged end to max(last end, current end).
 *      - Otherwise, there's a gap: add the current interval as a new one.
 *
 * Time: O(n log n) for the sort | Space: O(n) for the output
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0056MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // No overlap: start a new interval
                merged.add(interval);
            } else {
                // Overlap: extend the end of the last merged interval
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        LC0056MergeIntervals s = new LC0056MergeIntervals();
        System.out.println(Arrays.deepToString(
                s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))); // [[1, 6], [8, 10], [15, 18]]
        System.out.println(Arrays.deepToString(
                s.merge(new int[][]{{1, 4}, {4, 5}})));                    // [[1, 5]]
        System.out.println(Arrays.deepToString(
                s.merge(new int[][]{{1, 4}, {2, 3}})));                    // [[1, 4]]
        System.out.println(Arrays.deepToString(
                s.merge(new int[][]{{4, 7}, {1, 4}})));                    // [[1, 7]]
    }
}
