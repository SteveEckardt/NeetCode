/**
 * Problem: NeetCode - Merge Sort
 * Author: Steve Eckardt
 * Revision Date: July 1, 2025
 *
 * Recursively sorts a list of key-value pairs using merge sort and overwrites the input list in-place.
 *
 * Time Complexity:
 * - Overall: O(n log n)
 * - Space: O(n**2) due to temporary sublists created during merge
 */

class Solution {
    // Public entry point for merge sort
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(pairs, 0, pairs.size() - 1);
    }

    // Recursive sort on sublist [start, end]
    public List<Pair> mergeSort(List<Pair> pairs, int start, int end) {
        if (end - start <= 0) return pairs; // Base case: single element

        int middle = (start + end) / 2;

        // Recursively sort left and right halves
        mergeSort(pairs, start, middle);
        mergeSort(pairs, middle + 1, end);

        // Merge sorted halves
        mergeSort(pairs, start, middle, end);

        return pairs;
    }

    // Merge two sorted sublists into a single sorted segment
    public void mergeSort(List<Pair> pairs, int start, int middle, int end) {
        final List<Pair> LEFT = new ArrayList<>(pairs.subList(start, middle + 1));
        final List<Pair> RIGHT = new ArrayList<>(pairs.subList(middle + 1, end + 1));

        int LIndex = 0, RIndex = 0, pIndex = start;

        // Merge elements in sorted order
        while (LIndex < LEFT.size() && RIndex < RIGHT.size()) {
            if (RIGHT.get(RIndex).key < LEFT.get(LIndex).key)
                pairs.set(pIndex++, RIGHT.get(RIndex++));
            else
                pairs.set(pIndex++, LEFT.get(LIndex++));
        }

        // Copy any remaining elements
        while (LIndex < LEFT.size())
            pairs.set(pIndex++, LEFT.get(LIndex++));
        while (RIndex < RIGHT.size())
            pairs.set(pIndex++, RIGHT.get(RIndex++));
    }
}
