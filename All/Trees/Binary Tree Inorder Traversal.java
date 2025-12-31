/**
 * Problem: Binary Tree Inorder Traversal (NeetCode - Easy)
 * Author: Steve Eckardt
 * Revision Date: December 31, 2025
 * Description: Traverses a binary tree in inorder sequence (left, node, right).
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(h) — recursion stack where h is the height of the tree.
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
    
    // iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){ 
            while(current != null){ // Traverse left subtree
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val); // Visit current node
            current = current.right; // Traverse right subtree
        }
        return list;
    }    
    
    // recursion
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        iot(root, list); 
        return list;
    }

    private void iot(TreeNode current, List<Integer> list) {
        if (current == null) return; // Base case: empty subtree

        iot(current.left, list);     // Traverse left subtree
        list.add(current.val);       // Visit current node
        iot(current.right, list);    // Traverse right subtree
    }
}
