/**
 * Problem: Validate Binary Search Tree (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 8, 2025
 * Description: Checks whether a binary tree satisfies BST properties using both boundary recursion and in-order traversal methods.
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(h) for recursive boundary approach; O(n) for in-order list-based approach.
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
    public boolean isValidBST(TreeNode root){
        
        // Recursively validate with upper and lower bounds
        return isValidBST(root, -1001, 1001);
    }
    private boolean isValidBST(TreeNode node, int lower, int upper){
        
        if (node == null) return true;

        // Node value must be within (lower, upper) range
        if (node.val <= lower || node.val >= upper) return false;

        // Recurse left and right with updated bounds
        return isValidBST(node.left, lower, node.val) &&
               isValidBST(node.right, node.val, upper);
               
    } // end isValidBST  



// Alternative approach using in-order traversal
    public boolean isValidBST2(TreeNode root) {

        // Collect values in sorted (in-order) order
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int previous = Integer.MIN_VALUE;
        for (int i : list) {

            // BST must have strictly increasing values
            if (i <= previous) return false;
            previous = i;

        } // end for
        return true;
    } // end isValidBST

    // BST In-order traversal (Left, Node, Right)
    public void inOrder(TreeNode node, List<Integer> list) {

        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    } // end inOrder
} // end Solution
