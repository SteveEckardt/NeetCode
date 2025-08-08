/**
 * Problem: Merge Two Sorted Linked Lists (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: August 8, 2025
 * Description: Merges two sorted singly linked lists into one sorted list in-place.
 * Time Complexity: O(n + m) — each node in both lists is visited once.
 * Space Complexity: O(1) — merges lists without creating new nodes.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Handle null cases upfront
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Dummy head to simplify appending
        ListNode pointer = new ListNode(42, null);
        ListNode head = pointer;

        // Merge nodes in ascending order
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        // Append remaining nodes
        if(pointer.next == null)
            if (list1 != null) pointer.next = list1;
            else if (list2 != null) pointer.next = list2;

        return head.next; // Return merged list (skip dummy head)
    }
}
