/**
 * Problem: 3Sum (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 26, 2025
 * 
 * Description: Efficiently finds all unique triplets in a sorted array that
 *     sum to zero by skipping duplicates.
 * 
 * Time Complexity: O(n^2) – Outer loop O(n), inner loop O(n)
 * Space Complexity: O(1) – Ignoring output list
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort to enable two-pointer strategy
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            // Skip duplicate starting values
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Increase the sum
                } else {
                    right--; // Decrease the sum
                }
            }
        }

        return list;
    }
}


/**
 * Problem: 3Sum (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 26, 2025
 * 
 * Description: Finds all unique triplets in an array that sum to zero using
 *     sorting and two-pointer technique.
 * 
 * Time Complexity: O(n^2) – Outer loop O(n), inner loop O(n) in worst case
 * Space Complexity: O(n) – For storing result triplets
 */

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array for two-pointer traversal
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> three = Arrays.asList(nums[i], nums[left], nums[right]);

                    // Only add if triplet is not already in list
                    if (!list.contains(three)) {
                        list.add(three);
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Need a larger value
                } else {
                    right--; // Need a smaller value
                }
            }
        }

        return list;
    }
}
