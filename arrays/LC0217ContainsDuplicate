/*
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Approach: Hash set
 * Time: O(n) | Space: O(n)
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate s = new ContainsDuplicate();
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 1}));                   // true
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 4}));                   // false
        System.out.println(s.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); // true
    }
}
