/**
 * Problem: Search in Rotated Sorted Array (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: August 6, 2025
 * Description: Performs binary search on a rotated sorted array to locate a target element.
 * Time Complexity: O(log n) — binary search halves the search space each iteration.
 * Space Complexity: O(1) — uses constant space.
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (right >= left) {
            int middle = (left + right) / 2;

            // Target found
            if (nums[middle] == target) return middle;

            // Left half is sorted
            if (nums[left] <= nums[middle]) {
                // Target is not in the left sorted portion
                if (target < nums[left] || target > nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } 
            // Right half is sorted
            else {
                // Target is not in the right sorted portion
