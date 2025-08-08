/**
 * Problem: Linked List Cycle Detection (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: August 8, 2025
 * Description: Detects if a linked list contains a cycle using a HashSet to track visited nodes.
 * Time Complexity: O(n) — each node is visited at most once.
 * Space Complexity: O(n) — stores visited nodes in a HashSet.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false; // Empty list can't have a cycle

        Set<ListNode> visited = new HashSet<>();
        ListNode pointer = head;

        // Traverse list and check if a node repeats
        while (pointer != null) {
            if (visited.contains(pointer)) return true; // Cycle found
            visited.add(pointer); // Mark node as visited
            pointer = pointer.next;
        }

        return false; // No cycle detected
    }
}
