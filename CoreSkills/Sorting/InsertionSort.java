/**
 * Problem: NeetCode - Insertion Sort (Tracking Steps)
 * Author: Steve Eckardt
 * Revision Date: July 1, 2025
 *
 * Performs insertion sort on a list of key-value pairs and returns a list of the list's state after each iteration.
 *
 * Time Complexity:
 * - Overall: O(n^2)
 * - Space: O(n^2) for storing intermediate states
 */


public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
		
        List<List<Pair>> result = new ArrayList<>();
        int length = pairs.size();

        if (length == 0) return result;

        // Initial state before sorting
        result.add(new ArrayList<>(pairs));

        // Start insertion sort
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int key = pairs.get(i).key;

            // Swap backwards until correct position is found
            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, temp);
                j--;
            }

            // Capture current state after this step
            result.add(new ArrayList<>(pairs));
        }

        return result;
    }
}
