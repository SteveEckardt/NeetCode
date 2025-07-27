/**
 * Problem: Container With Most Water (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 26, 2025
 *
 * Description: Uses a two-pointer approach to find the maximum area of water a container can hold.
 *
 * Time Complexity: O(n) – Each pointer moves at most once per step
 * Space Complexity: O(1) – Constant space used
 */

class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        // Move two pointers inward to find the largest area
        while (left < right) {
            // Calculate current area using the shorter height
            int current = Math.min(heights[left], heights[right]) * (right - left);
            if(current > max) max = current;

            // Move the pointer at the shorter line inward
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
