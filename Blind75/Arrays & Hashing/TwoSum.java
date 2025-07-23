/**
 * Problem: Two Sum (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 23, 2025
 *
 * Description: Returns indices of the two numbers in the array that add up to the target using a hash map.
 *
 * Time Complexity: O(n), where n is the length of the array
 * Space Complexity: O(n), for storing values in the hash map
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store <difference, index> pairs
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // If current number matches a previously stored difference, return the pair
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }

            // Otherwise, store the complement needed to reach the target
            map.put(target - nums[i], i);
        }

        return new int[2]; // The problem guarantees one solution, but the compiler doesn't know that.
    }
}
