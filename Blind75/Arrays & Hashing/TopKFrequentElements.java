/**
 * Problem: Top K Frequent Elements (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 23, 2025
 *
 * Description: Returns the k most frequent elements in an integer array using bucket sort.
 *
 * Time Complexity: O(n), where n is the length of the input array
 * Space Complexity: O(n), for frequency map and bucket array
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build a frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Step 2: Create frequency buckets (index = frequency)
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Fill the buckets based on frequency
        int max = -1;
        for (int key : map.keySet()) {
            int val = map.get(key);
            bucket[val].add(key);
            if (val > max) max = val; // Track highest frequency
        }

        // Step 4: Collect top k frequent elements from highest bucket down
        int[] result = new int[k];
        int index = 0;

        while (index < k) {
            if (bucket[max].isEmpty()) {
                max--;
            } else {
                result[index++] = bucket[max].remove(0);
            }
        }

        return result;
    }
}
