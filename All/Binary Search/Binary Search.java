/**
 * Problem: Binary Search (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: January 10, 2026
 * Description: Searches for a target value in a sorted array using recursive and iterative binary search.
 * Time Complexity: O(log n) — halves the search space each step.
 * Space Complexity: O(log n) for recursive version (call stack), O(1) for iterative version.
 */

class Solution {

    // Recursive binary search
    public int search(int[] nums, int target){
        return search(0, nums.length - 1, nums, target);
    }

    // Recursive binary search helper
    public int search(int left, int right, int[] nums, int target){
        if (left > right) return -1; // Base case: target not found

        int middle = (left + right) / 2;

        if (nums[middle] == target) return middle;

        // Recurse into the appropriate half
        return nums[middle] > target
                ? search(left, middle - 1, nums, target)
                : search(middle + 1, right, nums, target);
    }

    // Iterative binary search
    public int search_iterative(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) return middle;

            if (nums[middle] > target)
                right = middle - 1; // Search left half
            else
                left = middle + 1;  // Search right half
        }
        return -1; // Target not found
    }
}
