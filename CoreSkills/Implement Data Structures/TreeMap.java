/**
 * Problem: NeetCode - Design Binary Search Tree (TreeMap)
 * Author: Steve Eckardt
 * Revision Date: June 30, 2025
 *
 * A simple key-value store backed by a binary search tree.
 * Supports insertion, retrieval, deletion, and in-order traversal.
 *
 * Time Complexity:
 * - insert(key, val)    => O(h)
 * - get(key)            => O(h)
 * - getMin()/getMax()   => O(h)
 * - remove(key)         => O(h)
 * - getInorderKeys()    => O(n)
 * Where h = height of the tree, n = total nodes
 */

//import java.util.ArrayList;
//import java.util.List;

public class TreeMap {
    // Internal node class
    class Node {
        int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Initialize an empty tree
    public TreeMap() {
        root = null;
    }

    // Public insert method
    public void insert(int key, int value) {
        root = insert(root, key, value);
    }

    // Recursively insert node or update existing key
    private Node insert(Node node, int key, int value) {
        if (node == null) return new Node(key, value);

        if (key == node.key) {
            node.value = value; // Overwrite existing value
        } else if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    // Retrieve value by key
    public int get(int key) {
        return get(root, key);
    }

    private int get(Node node, int key) {
        if (node == null) return -1;

        if (key == node.key) return node.value;
        if (key < node.key) return get(node.left, key);
        return get(node.right, key);
    }

    // Return value of minimum key
    public int getMin() {
        if (root == null) return -1;

        Node node = root;
        while (node.left != null) node = node.left;

        return node.value;
    }

    // Return value of maximum key
    public int getMax() {
        if (root == null) return -1;

        Node node = root;
        while (node.right != null) node = node.right;

        return node.value;
    }

    // Remove a key from the tree
    public void remove(int key) {
        root = remove(root, key);
    }

    private Node remove(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            // Node with one or no children
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: replace with inorder successor
            Node successor = getMinNode(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = remove(node.right, successor.key);
        }

        return node;
    }

    // Helper to get node with minimum key
    private Node getMinNode(Node node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Returns list of keys in sorted (inorder) order
    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        getInorderKeys(list, root);
        return list;
    }

    private void getInorderKeys(List<Integer> list, Node node) {
        if (node == null) return;

        getInorderKeys(list, node.left);
        list.add(node.key);
        getInorderKeys(list, node.right);
    }
}
