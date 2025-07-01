/**
 * Problem: NeetCode - Quick Sort
 * Author: Steve Eckardt
 * Revision Date: July 1, 2025
 *
 * Sorts a list of key-value pairs in-place using the Quick Sort algorithm with Lomuto partitioning.
 *
 * Time Complexity:
 * - Average case: O(n log n)
 * - Worst case: O(n^2) when pivot choice is poor (e.g., already sorted)
 * - Space: O(log n) recursive stack (average), O(n) worst case
 */

// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }

class Solution {
    // Public entry point for quick sort
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSort(pairs, 0, pairs.size() - 1);
    }

    // Recursive quick sort on sublist [start, end]
    public List<Pair> quickSort(List<Pair> pairs, int start, int end) {
        if (end - start <= 0) return pairs; // Base case: one or no elements

        int pivot = pairs.get(end).key; // Choose pivot from the end
        int left = start;

        // Partition: elements < pivot to the left
        for (int i = start; i < end; i++) {
            if (pairs.get(i).key < pivot) {
                Pair temp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, temp);
                left++;
            }
        }

        // Place pivot in its correct position
        Pair temp = pairs.get(left);
        pairs.set(left, pairs.get(end));
        pairs.set(end, temp);

        // Recursively sort left and right partitions
        quickSort(pairs, start, left - 1);
        quickSort(pairs, left + 1, end);

        return pairs;
    }
}