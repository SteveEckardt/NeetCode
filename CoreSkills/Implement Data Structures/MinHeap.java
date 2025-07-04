/**
 * Problem: NeetCode - Design Min Heap
 * Author: Steve Eckardt
 * Revision Date: June 30, 2025
 *
 * A basic min-heap (priority queue) implementation using a list with 1-based indexing.
 *
 * Time Complexity:
 * - push(val)         => O(log n)
 * - pop()             => O(log n)
 * - top()             => O(1)
 * - heapify(List)     => O(n log n) (using repeated insert)
 */

public class MinHeap {
    private List<Integer> heap;

    // Initialize heap with a dummy value at index 0 (1-based indexing)
    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    // Insert a value into the heap and bubble it up
    public void push(int val) {
        heap.add(val);
        int index = heap.size() - 1;

        // Bubble up while smaller than parent
        while (index > 1 && heap.get(index) < heap.get(index / 2)) {
            int temp = heap.get(index);
            heap.set(index, heap.get(index / 2));
            index /= 2;
            heap.set(index, temp);
        }
    }

    // Remove and return the minimum value (root)
    public Integer pop() {
        int size = heap.size();
        if (size < 2) return -1; // Empty heap
        if (size == 2) return heap.remove(1); // Single element

        int result = heap.get(1);
        heap.set(1, heap.remove(--size)); // Move last to root
        int value = heap.get(1);
        int index = 1;
        size--;

        // Bubble down to maintain heap property
        while (true) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;

            if (index * 2 <= size && heap.get(index * 2) < value)
                left = heap.get(index * 2);
            if (index * 2 + 1 <= size && heap.get(index * 2 + 1) < value)
                right = heap.get(index * 2 + 1);

            if (left < right && left < value) {
                heap.set(index, left);
                heap.set(index * 2, value);
                index *= 2;
            } else if (right < value) {
                heap.set(index, right);
                heap.set(index * 2 + 1, value);
                index = index * 2 + 1;
            } else {
                break;
            }
        }

        return result;
    }

    // Return the minimum value without removing it
    public Integer top() {
        if (heap.size() > 1) return heap.get(1);
        return -1;
    }

    // Build a heap from a list of values
    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>();
        heap.add(0);
        for (Integer num : nums) {
            push(num); // Repeated insert
        }
    }
}