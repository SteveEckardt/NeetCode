/**
 * Problem: Number of One Bits (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: November 12, 2025
 * Description: Counts the number of set bits (1s) in an integer using bitwise operations and arithmetic fallback.
 * Time Complexity: O(k) — where k is the number of bits (32 for int).
 * Space Complexity: O(1) — uses constant extra memory.
 */

class Solution {
    public int hammingWeight(int n) {
        int result = 0;

        // Each iteration removes the lowest set bit
        while(n != 0){
            n &= (n-1); // Clear the lowest 1-bit
            result++;
        }
        return result;
    }

    public int hammingWeight1(int n) {
        int result = 0;
        while(n != 0){
            // Check lowest bit using bitwise AND
            if ((n & 1) == 1) result++;
            n >>= 1; // Shift right to inspect next bit
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int result = 0;
        while(n>0){
            // Check parity via modulo
            if (n % 2 == 1) result++;
            n /= 2; // Move to next bit through division
        }
        return result;
    }
}