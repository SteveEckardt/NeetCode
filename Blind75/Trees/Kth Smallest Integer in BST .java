/**
 * Problem: Kth Smallest Element in a BST (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 8, 2025
 * Description: Finds the kth smallest value in a Binary Search Tree using in-order traversal (ascending order).
 * Time Complexity: O(n) — in-order traversal visits each node once.
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
    public int kthSmallest(TreeNode root, int k){
        
        int[] countResult = {k, 0}; // [remaining count, result value]
        inOrder(root, countResult);
        return countResult[1];
    }

    public void inOrder(TreeNode node, int[] countResult){
        
        // Stop early if we've already found the kth element
        if (node == null || countResult[0] <= 0) return;

        inOrder(node.left, countResult);

        // Decrement count and check if this is the kth node
        if (countResult[0]-- == 1) {
            countResult[1] = node.val;
            return;
        }
        inOrder(node.right, countResult);
        
    }// end inOrder

    // Alternate approach: build reversed in-order list (descending)
    public int kthSmallest2(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        reOrder(root, list);
        return list.get(list.size() - k);
    }

    public void reOrder(TreeNode node, List<Integer> list){
        
        if (node == null) return;
        reOrder(node.right, list);
        list.add(node.val);
        reOrder(node.left, list);
        
    }// end reOrder
}
