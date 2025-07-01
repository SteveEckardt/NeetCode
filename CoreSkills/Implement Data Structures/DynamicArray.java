/**
 * Problem: NeetCode - Design Dynamic Array (Resizable Array)
 * Author: Steve Eckardt
 * Revision Date: June 30, 2025
 *
 * A simple implementation of an ArrayList/Stack from scratch.
 *
 * Time Complexity:
 * - get(i)      => O(1)  // Direct access by index
 * - set(i, n)   => O(1)  // Direct assignment by index
 * - pushback(n) => Amortized O(1), worst-case O(n) when resizing
 * - popback()   => O(1)  // Just decrements size and returns value
 * - resize()    => O(n)  // Copies all elements to new array (called infrequently)
 * - getSize()   => O(1)
 * - getCapacity() => O(1)
 */


public class DynamicArray {
    private int[] data;      // Underlying storage
    private int size;        // Number of elements stored
    private int capacity;    // Current allocated capacity

    public DynamicArray(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    // Returns element at index i
    public int get(int i) {
        return this.data[i];
    }

    // Sets element at index i to value n
    public void set(int i, int n) {
        this.data[i] = n;
    }

    // Appends value n to the end of the array
    public void pushback(int n) {
        if (size == capacity) resize();
        this.data[size++] = n;
    }

    // Removes and returns the last element
    public int popback() {
        return this.data[--size];
    }

    // Doubles array capacity and copies existing elements
    private void resize() {
        int[] newArray = new int[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.data[i];
        }
        this.data = newArray;
        this.capacity *= 2;
    }

    // Returns the current number of elements
    public int getSize() {
        return this.size;
    }

    // Returns the current capacity of the array
    public int getCapacity() {
        return this.capacity;
    }
}