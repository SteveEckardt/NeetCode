/**
 * Problem: Maximum Depth of Binary Tree (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: October 7, 2025
 * Description: Recursively calculates the maximum depth (height) of a binary tree.
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(h) — recursion stack where h is the tree height (O(n) worst case).
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // Base case: empty subtree has depth 0
        // Depth is 1 (for current node) + max depth of left or right subtree
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
