/**
 * Problem: Counting Bits (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: October 13, 2025
 * Description: Computes the number of set bits for all integers from 0 to n using a dynamic programming recurrence.
 * Time Complexity: O(n) — each value from 1 to n is computed in O(1) time.
 * Space Complexity: O(n) — stores the bit-count for all integers up to n.
 */

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        // For each number i, use the recurrence:
        // bits(i) = bits(i >> 1) + (i & 1)
        for (int i = 1; i <= n; i++)
            result[i] = result[i >> 1] + (i & 1);

        return result;
    }   
}
