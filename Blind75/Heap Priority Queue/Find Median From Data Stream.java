/**
 * Problem: Find Median From Data Stream (NeetCode Blind 75 - Hard)
 * Author: Steve Eckardt
 * Revision Date: October 18, 2025
 * Description: Computes the median dynamically from a stream of integers using a max-heap and temporary list reconstruction.
 * Time Complexity: O(n) per median query — elements are re-polled and reinserted.
 * Space Complexity: O(n) — stores all elements in the queue and temporary list.
 */

class MedianFinder {
    // Max-heap storing all elements (reverse order)
    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}

    public void addNum(int num) {
        queue.add(num); // Insert number into heap
    }

    public double findMedian() {

        int size = queue.size();
        int target = size / 2;
        double result;
        List<Integer> list = new ArrayList<>(size);

        // Extract elements until reaching middle position
        for (int i = 0; i <= target; i++) {
            list.add(queue.poll());
        }

        // Odd count → middle element; even → average of two middle elements
        if (size % 2 == 1) {
            result = list.get(target);
        } else {
            result = (list.get(target) + list.get(target - 1)) / 2.0;
        }

        // Restore heap by reinserting all elements
        while (!list.isEmpty()) {
            queue.add(list.remove(0));
        }

        return result;
    }
}
