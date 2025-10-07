/**
 * Problem: Subtree of Another Tree (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: October 7, 2025
 * Description: Determines if one binary tree is a subtree of another using recursive comparison.
 * Time Complexity: O(m * n) — in the worst case, compares each node of root (n) with each node of subRoot (m).
 * Space Complexity: O(h) — recursion stack where h is the height of the larger tree.
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        // An empty tree is always a subtree
        if (subRoot == null) return true;   
        
        // Can't find a subtree in an empty tree
        if (root == null) return false;     

        // If values match, check structural equality
        if (root.val == subRoot.val && isSameTree(root, subRoot))     
            return true;

        // Otherwise, check left or right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper Method: checks if two trees are identical
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
