/**
 * Problem: Sum of All Subsets XOR Total (NeetCode - Easy)
 * Author: Steve Eckardt
 * Revision Date: January 13, 2026
 * Description: Computes the sum of XOR values for all possible subsets using depth-first search and backtracking.
 * Time Complexity: O(2^n) — all subsets are explored.
 * Space Complexity: O(n) — recursion depth and temporary subset storage.
 */

class Solution {
    public int subsetXORSum(int[] nums) {
        // Start DFS with index 0 and initial XOR total of 0
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int i, int total) {
        // Base case: one subset completed
        if (i == nums.length) return total;

        // Include nums[i] in XOR or exclude it
        return dfs(nums, i + 1, total ^ nums[i]) +
               dfs(nums, i + 1, total);
    }
}

/**
 * Alternate backtracking-based solution for clarity
 */
class Solution2 {
    private int result;
    private List<Integer> list;
    private int[] nums;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        this.result = 0;
        this.list = new ArrayList<>();
        backtrack(0);
        return this.result;
    }

    private void backtrack(int i) {
        // Compute XOR of the current subset
        int current = 0;
        for (int l : this.list) current ^= l;

        // Add current subset XOR to result
        this.result += current;

        int len = this.nums.length;
        for (int j = i; j < len; j++) {
            // Choose nums[j]
            list.add(this.nums[j]);
            backtrack(j + 1);

            // Backtrack
            list.remove(this.list.size() - 1);
        }
    }
}
