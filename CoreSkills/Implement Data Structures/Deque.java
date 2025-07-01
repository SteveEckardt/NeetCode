/**
 * Problem: NeetCode - Design Double-Ended Queue (Deque)
 * Author: Steve Eckardt
 * Revision Date: June 30, 2025
 *
 * A basic implementation of a deque using a doubly linked list.
 * Supports constant-time insertions and removals at both ends.
 *
 * Time Complexity:
 * - append(value)     => O(1)
 * - appendleft(value) => O(1)
 * - pop()             => O(1)
 * - popleft()         => O(1)
 * - isEmpty()         => O(1)
 */

public class Deque {
    // Doubly linked node
    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node leftEnd;   // Points to the front of the deque
    private Node rightEnd;  // Points to the back of the deque
    private int size;

    // Initializes an empty deque
    public Deque() {
        this.leftEnd = null;
        this.rightEnd = null;
        this.size = 0;
    }

    // Returns true if deque is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Adds value to the right end
    public void append(int value) {
        Node current = new Node(value);

        if (this.rightEnd == null) {
            this.leftEnd = current;
            this.rightEnd = current;
        } else {
            this.rightEnd.right = current;
            current.left = this.rightEnd;
            this.rightEnd = current;
        }

        this.size++;
    }

    // Adds value to the left end
    public void appendleft(int value) {
        Node current = new Node(value);

        if (this.leftEnd == null) {
            this.leftEnd = current;
            this.rightEnd = current;
        } else {
            this.leftEnd.left = current;
            current.right = this.leftEnd;
            this.leftEnd = current;
        }

        this.size++;
    }

    // Removes and returns value from the right end
    public int pop() {
        if (isEmpty()) return -1;

        int result = this.rightEnd.value;

        if (this.size == 1) {
            this.leftEnd = null;
            this.rightEnd = null;
        } else {
            this.rightEnd = this.rightEnd.left;
            this.rightEnd.right = null;
        }

        this.size--;
        return result;
    }

    // Removes and returns value from the left end
    public int popleft() {
        if (isEmpty()) return -1;

        int result = this.leftEnd.value;

        if (this.size == 1) {
            this.leftEnd = null;
            this.rightEnd = null;
        } else {
            this.leftEnd = this.leftEnd.right;
            this.leftEnd.left = null;
        }

        this.size--;
        return result;
    }
}
