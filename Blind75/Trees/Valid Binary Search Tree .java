/**
 * Problem: Validate Binary Search Tree (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 8, 2025
 * Description: Determines if a binary tree satisfies BST properties by checking in-order traversal for strictly increasing order.
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(n) — stores all node values during traversal.
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
    public boolean isValidBST(TreeNode root) {

        // Collect values in sorted (in-order) order
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int previous = Integer.MIN_VALUE;
        for (int i : list) {

            // BST must have strictly increasing values
            if (i <= previous) return false;
            previous = i;

        }// end for
        return true;
    }// end isValidBST

    // BST In-order traversal (Left, Node, Right)
    public void inOrder(TreeNode node, List<Integer> list) {

        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    }// end inOrder
}// end Solution
