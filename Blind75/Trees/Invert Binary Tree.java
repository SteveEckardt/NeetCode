/**
 * Problem: Invert Binary Tree (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: October 7, 2025
 * Description: Recursively swaps left and right children of each node to invert the binary tree.
 * Time Complexity: O(n) — visits every node once.
 * Space Complexity: O(h) — recursion stack where h is the height of the tree (O(n) worst case).
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;  // Base case: empty subtree

        // Swap left and right subtrees recursively
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root; // Return the new root of the inverted subtree
    }
}
