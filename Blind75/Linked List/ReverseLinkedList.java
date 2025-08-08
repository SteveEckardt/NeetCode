/**
 * Problem: Reverse Linked List (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: August 8, 2025
 * Description: Reverses a singly linked list by building a new reversed list.
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(n) — creates new nodes for each element.
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
    public ListNode reverseList(ListNode head) {
        if (head == null) return head; // Empty list check

        ListNode pointer = head;       // Pointer to traverse the list
        ListNode reverse = null;       // Head of the reversed list

        while (pointer != null) {
            // Create new node in front of the reversed list
            reverse = new ListNode(pointer.val, reverse);
            pointer = pointer.next;    // Move forward in original list
        }

        return reverse; // New head of reversed list
    }
}
