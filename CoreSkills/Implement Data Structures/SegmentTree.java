/**
 * Problem: NeetCode - Design Segment Tree  
 * Author: Steve Eckardt  
 * Revision Date: July 7, 2025  
 *
 * Implements a segment tree for efficient range sum queries and point updates on an integer array.
 *
 * Time Complexity:
 * - buildTree: O(n)
 * - update(index, val): O(log n)
 * - query(left, right): O(log n)
 *
 * Space Complexity: O(n) for storing the segment tree nodes
 */

class SegmentTree {

    // Internal tree node class
    class Node {
        int sum;       // Sum of the current range
        Node left;     // Left child
        Node right;    // Right child
        int li, ri;    // li = leftIndex, ri = rightIndex, Range: [li, ri]

        public Node(int sum, int li, int ri) {
            this.sum = sum;
            this.li = li;
            this.ri = ri;
            this.left = null;
            this.right = null;
        }
    }// end class Node

    private Node root;

    // Constructor: builds tree from input array
    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    // Recursively builds the segment tree
    private Node buildTree(int[] nums, int li, int ri) {
        if (li == ri) return new Node(nums[li], li, ri);

        int middle = (li + ri) / 2;
        Node current = new Node(0, li, ri);
        current.left = buildTree(nums, li, middle);
        current.right = buildTree(nums, middle + 1, ri);
        current.sum = current.left.sum + current.right.sum;
        return current;
    }// end buildTree

    // Public method to update a value at given index
    public void update(int index, int val) {
        update(this.root, index, val);
    }
    // Recursively updates the segment tree
    private void update(Node current, int index, int val) {
        if (current.li == current.ri) {
            current.sum = val;
            return;
        }

        int middle = (current.li + current.ri) / 2;
        if (index <= middle) update(current.left, index, val);
        else update(current.right, index, val);

        current.sum = current.left.sum + current.right.sum;
    }// end update

    // Public method to query sum in range [li, ri]
    public int query(int li, int ri) {
        return query(this.root, li, ri);
    }
    // Recursively queries the range sum
    private int query(Node current, int li, int ri) {
        if (current.li == li && current.ri == ri) return current.sum;

        int middle = (current.li + current.ri) / 2;

        if (ri <= middle) {
            return query(current.left, li, ri);
        } else if (li > middle) {
            return query(current.right, li, ri);
        } else {
            return query(current.left, li, middle) +
                   query(current.right, middle + 1, ri);
        }
    }// end query
}// end class SegmentTree
