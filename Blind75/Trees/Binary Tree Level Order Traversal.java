/**
 * Problem: Binary Tree Level Order Traversal (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 8, 2025
 * Description: Performs a breadth-first traversal of a binary tree, returning node values level by level.
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(n) — queue and result list store up to all nodes in the tree.
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        // Empty tree edge case
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Recursive helper for BFS traversal
        return levelOrder(queue, list);
        
    }// end levelOrder

    private List<List<Integer>> levelOrder(Queue<TreeNode> queue, List<List<Integer>> list) {

        if (queue == null || queue.peek() == null) return list;

        // next level
        Queue<TreeNode> next = new LinkedList<>();
        // values from this level
        List<Integer> level = new ArrayList<>();

        // Process all nodes at the current level
        while (queue.peek() != null) {
            
            TreeNode node = queue.remove();
            
            level.add(node.val);

            // Enqueue child nodes for next level
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
            
        }// end while

        // Add this level’s values and recurse for the next level
        list.add(level);
        return levelOrder(next, list);
        
    }// end levelOrder recursive
}// end class Solution
