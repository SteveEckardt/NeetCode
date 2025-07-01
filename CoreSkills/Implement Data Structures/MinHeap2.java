/**
 * Problem: NeetCode - Design Heap (MinHeap)
 * Author: Steve Eckardt
 * Revision Date: June 30, 2025
 *
 * A 1-indexed array-based implementation of a Min Heap,
 * supporting insertion, removal, and heap construction.
 *
 * Time Complexity:
 * - push(val)     => O(log n)
 * - pop()         => O(log n)
 * - top()         => O(1)
 * - heapify(List) => O(n log n) via repeated insert
 */

public class MinHeap {
    private List<Integer> heap;

    // Initialize heap with dummy at index 0 for simpler index math
    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    // Insert value and bubble up to restore heap property
    public void push(int val) {
        heap.add(val);
        int index = heap.size() - 1;

        // While parent is greater, swap up
        while (index > 1 && heap.get(index) < heap.get(index / 2)) {
            int temp = heap.get(index);
            heap.set(index, heap.get(index / 2));
            index /= 2;
            heap.set(index, temp);
        }
    }

    // Remove and return the smallest value (root)
    public Integer pop() {
        int size = heap.size();
        if (size < 2) return -1;       // Heap is empty
        if (size == 2) return heap.remove(1); // Only one element

        int result = heap.get(1);
        heap.set(1, heap.remove(--size)); // Move last to root
        int value = heap.get(1);
        int index = 1;
        size--;

        // Bubble down to restore heap property
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

    // Return the smallest value without removing it
    public Integer top() {
        return heap.size() > 1 ? heap.get(1) : -1;
    }

    // Build a heap from an existing list of integers
    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>();
        heap.add(0);
        for (Integer num : nums) {
            push(num); // Repeated inserts
        }
    }
}
