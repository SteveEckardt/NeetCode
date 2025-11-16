/**
 * Problem: Combination Sum (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 16, 2025
 * Description: Builds valid target-sum combinations by expanding partial sums in a tree-like structure.
 * Time Complexity: O(n * k) — n = number of candidates, k = number of generated partial states.
 * Space Complexity: O(k) — stores intermediate partial combinations until solutions are found.
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> tree = new ArrayList<>();

        // Seed tree with a "state" list: first element holds current sum
        tree.add(new ArrayList<Integer>());
        tree.get(0).add(0); // current sum = 0

        for (int n : nums) {
            if (n > target) return result; // Skip candidates larger than target

            if (n == target) {
                // Direct match: store as single-element solution
                List<Integer> list = new ArrayList<>();
                list.add(n);
                result.add(list);
                return result;
            } else {
                // Iterate over current partial states
                for (int i = 0; i < tree.size(); i++) {
                    List current = tree.get(i);
                    int size = (Integer) current.get(0); // stored partial sum

                    if (n + size <= target) {
                        // Create new state extended with n
                        List<Integer> copy = new ArrayList(current);
                        copy.add(n);

                        if (n + size == target) {
                            // Found complete combination
                            copy.remove(0);     // remove stored sum
                            result.add(copy);
                        } else {
                            // Save iteration to tree and continue exploring
                            copy.set(0, n + size); 
                            tree.add(copy);
                        }
                    }
                }
            }
        }
        return result;
    }
}
