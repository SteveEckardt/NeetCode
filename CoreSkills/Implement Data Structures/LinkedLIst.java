/**
 * Problem: NeetCode - Design Singly Linked List
 * Author: Steve Eckardt
 * Revision Date: June 30, 2025
 *
 * A basic implementation of a singly linked list with support for
 * insertions, removals, and retrieval by index.
 *
 * Time Complexity:
 * - get(index)      => O(n)
 * - insertHead(val) => O(1)
 * - insertTail(val) => O(1)
 * - remove(index)   => O(n)
 * - getValues()     => O(n)
 */

//import java.util.ArrayList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    // Internal node class
    class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Initializes an empty list
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Returns value at index, or -1 if out of bounds
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // Inserts a new node at the head
    public void insertHead(int val) {
        Node current = new Node(val);
        current.next = this.head;
        this.head = current;

        if (size == 0) this.tail = current; // First node is both head and tail
        size++;
    }

    // Appends a new node at the tail
    public void insertTail(int val) {
        Node current = new Node(val);

        if (size == 0) {
            this.head = current;
            this.tail = current;
        } else {
            this.tail.next = current;
            this.tail = current;
        }
        size++;
    }

    // Removes node at given index, returns true if successful
    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;

        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) tail = null; // List became empty
            return true;
        }

        Node previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }

        previous.next = previous.next.next;
        if (index == size - 1) tail = previous; // Removed last node
        size--;
        return true;
    }

    // Returns all values as a list
    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }
}
