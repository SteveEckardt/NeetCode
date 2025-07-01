/**
 * Problem: Selection Sort (Key-Value Pairs)
 * Author: Steve Eckardt
 * Revision Date: July 1, 2025
 *
 * Performs selection sort on a list of key-value pairs and returns each step of the sort.
 *
 * Time Complexity:
 * - Time: O(n^2)
 * - Space: O(n^2) if tracking steps; O(1) in-place otherwise
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

public class Solution {
    public List<List<Pair>> selectionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
        int length = pairs.size();

        // Record initial state
        result.add(new ArrayList<>(pairs));

        for (int i = 0; i < length; i++) {
            int candidateKey = pairs.get(i).key;
            int candidateIndex = i;

            // Find the smallest remaining value
            for (int j = i + 1; j < length; j++) {
                if (pairs.get(j).key < candidateKey) {
                    candidateKey = pairs.get(j).key;
                    candidateIndex = j;
                }
            }

            // Swap if a smaller element was found
            if (i != candidateIndex) {
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(candidateIndex));
                pairs.set(candidateIndex, temp);
            }

            // Record current state
            result.add(new ArrayList<>(pairs));
        }

        return result;
    }
}
