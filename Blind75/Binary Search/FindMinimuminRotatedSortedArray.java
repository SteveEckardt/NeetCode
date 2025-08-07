/**
 * Problem: Find Minimum in Rotated Sorted Array (NeetCode - Blind 75)
 * Author: Steve Eckardt
 * Revision Date: August 6, 2025
 * Description: Uses binary search to find the smallest element in a rotated sorted array.
 * Time Complexity: O(log n) for findMin, O(n) for findMin2
 * Space Complexity: O(1) — both methods use constant space
 */
class Solution {
    
    // Optimized binary search solution
    public int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            // If mid is less than right, the min is in the left half (including mid)
            if (nums[middle] < nums[right]) {
                right = middle;
            } else {
                // Min is in the right half (excluding mid)
                left = middle + 1;
            }
        }

        // Left will point to the smallest value
        return nums[left];
    }

    // Brute-force linear search for comparison/debugging
    public int findMin2(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n < min) min = n;
        }

        return min;
    }
}
