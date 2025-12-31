/**
 * Problem: Concatenation of Array (NeetCode - Easy)
 * Author: Steve Eckardt
 * Revision Date: December 30, 2025
 * Description: Creates a new array by concatenating an array with itself in a single pass.
 * Time Complexity: O(n) — each element is copied once.
 * Space Complexity: O(n) — allocates a new array of size 2n.
 */

class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int result[] = new int[len * 2]; 

        // Copy each element into both halves of the result array
        for (int i = 0; i < len; i++) {
            result[i] = result[i + len] = nums[i];
        }

        return result;
    }
    
    public int[] getConcatenation2(int[] nums) {
        int len = nums.length;
        int[] result = new int[len * 2];

        // Copy nums into the first half
        System.arraycopy(nums, 0, result, 0, len);

        // Copy nums into the second half
        System.arraycopy(nums, 0, result, len, len);

        return result;
    }    
}
