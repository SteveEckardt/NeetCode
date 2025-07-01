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


class DynamicArray {
    private int[] data;      // The actual array — where the magic happens
    private int size;        // How many elements we *actually* have
    private int capacity;    // How many elements we *can* hold before freaking out

    public DynamicArray(int capacity) {
        this.data = new int[capacity]; 	// Start with some room to grow
        this.size = 0;                 	// Empty, like my weekend plans
        this.capacity = capacity;      	// Set the initial storage limit
    }

    public int get(int i) {
        return this.data[i]; 	// Just peeking at index i
    }

    public void set(int i, int n) {
        this.data[i] = n;    	// Overwrite whatever was there — no regrets
    }

    public void pushback(int n) {
        if(size == capacity) resize(); 	// Uh-oh, no space? Time to double down
        this.data[size++] = n;         	// No worries just put it on the end of array
    }

    public int popback() {
        return this.data[--size]; 	// Give me that back I've got plans for it
    }

    private void resize() {
        int[] newArray = new int[this.capacity * 2]; 	// Get a bigger boat
        for(int i = 0; i < this.capacity; i++) 
			newArray[i] = this.data[i]; 		// Copy the old into the new
        this.data = newArray;     				// Replace the old array with the shiny new one
        capacity *= 2;            				// Double the storage space — go big or go home
    }

    public int getSize() {
        return this.size; 	// Current headcount
    }

    public int getCapacity() {
        return this.capacity; 	// Total room available (for now)
    }
}