/**
 * Problem: Contains Duplicate (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 22, 2025
 *
 * Description: Determines if any value appears more than once in the input array.
 *
 * HashSet
 * Time Complexity: O(n) — one pass through the array with constant-time set operations
 * Space Complexity: O(n) — in the worst case, stores all elements in the set
 *
 * Sort
 * Time Complexity: O(n log n) — due to sorting
 * Space Complexity: O(1) — in-place sorting (ignoring input size)
 */

class Solution_Sort {
    public boolean hasDuplicate(int[] nums) {
        
        Arrays.sort(nums); // Sort the array so duplicates are adjacent
        int last = Integer.MAX_VALUE; // Initialize to a value unlikely to be the first input

        for (int n : nums) {
            if (n == last) return true; // Duplicate found
            last = n; // Update last seen number
        }

        return false; // No duplicates found
    }

class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int n: nums){
            if( set.contains(n) ) return true;  // Duplicate found
            set.add(n); // Add to set if not already present
        }
        
        return false; // No duplicates found
    }
}
    
}
