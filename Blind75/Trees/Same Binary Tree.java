/**
 * Problem: Same Binary Tree (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: October 7, 2025
 * Description: Recursively checks if two binary trees are identical in both structure and node values.
 * Time Complexity: O(n) — visits each node once.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, trees match at this branch
        if (p == null && q == null) return true;

        // If only one is null, trees differ
        if (p == null || q == null) return false;

        // Values must match at this node
        if (p.val != q.val) return false;

        // Recurse on left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
