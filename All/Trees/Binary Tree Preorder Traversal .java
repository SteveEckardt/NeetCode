/**
 * Problem: Binary Tree Preorder Traversal (NeetCode - Easy)
 * Author: Steve Eckardt
 * Revision Date: December 31, 2025
 * Description: Traverses a binary tree in preorder sequence (node, left, right) using both iterative and recursive approaches.
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(h) — stack or recursion depth where h is the height of the tree.
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
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // Continue while there are nodes to process
        while(current != null || !stack.isEmpty()){
            if(current != null){
                list.add(current.val);     // Visit node 
                stack.push(current.right); // Defer right subtree
                current = current.left;    // Move to left subtree
            }
            else{
                current = stack.pop();       // Process deferred right subtree
            }
        }
        return list;
    }

    // recursion
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list); 
        return list;
    }

    private void preorder(TreeNode current, List<Integer> list){
        if(current == null) return;  // Base case
        list.add(current.val);       // Visit node
        preorder(current.left, list); // Move to left subtree
        preorder(current.right, list); // Move to right subtree
    }
}
