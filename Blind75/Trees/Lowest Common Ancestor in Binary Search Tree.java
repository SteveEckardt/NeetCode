/**
 * Problem: Lowest Common Ancestor in Binary Search Tree (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 7, 2025
 * Description: Recursively finds the lowest common ancestor (LCA) of two nodes in a BST using value comparisons.
 * Time Complexity: O(h) — where h is the height of the tree.
 * Space Complexity: O(h) — recursion stack depth proportional to tree height.
 * Critique: For a Binary Search Tree, this problem is more accurately described as finding the split point where the search paths diverge, rather than a structural ancestor.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Defensive check
        if (root == null || p == null || q == null) return null; 

        // If both nodes are smaller, LCA is in the left subtree
        if (root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);

        // If both nodes are larger, LCA is in the right subtree
        if (root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);

        // Otherwise, this node splits the path — it's the LCA
        return root;
    }
}
