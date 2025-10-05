/**
 * Problem: Remove Nth Node From End of Linked List (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 5, 2025
 * Description: Removes the nth node from the end of a singly linked list using recursive and iterative approaches.
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(n) — recursive call stack (or O(1) for iterative versions).
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

    // Recursive approach using array reference to track nth node
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return recurseNthFromEnd(head, new int[]{n});
    }

    private ListNode recurseNthFromEnd(ListNode head, int[] n) {
        if (head == null) return head;          // Test for end of list
        head.next = recurseNthFromEnd(head.next, n); // Recoures to end of list and Undate node
        if (--n[0] == 0) return head.next;      // Found node to remove;
        return head;                            // Return reconstructed list
    }

    // Iterative approach — two passes
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return head;

        // First pass: get size
        int size = 0;
        ListNode pointer = head;
        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }

        // Handle single node case
        if (size == 1) return null;

        int removeIndex = size - n;
        if (removeIndex == 0) return head.next; // Handle remove first node head

        // Second pass: remove nth node
        int index = 0;
        pointer = head;
        while (index < removeIndex) {
            if (index + 1 == removeIndex) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
            index++;
        }

        return head;
    }

    // ArrayList-based rebuild (less efficient, more illustrative)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();
        ListNode pointer = head;

        // Convert linked list to array
        while (pointer != null) {
            list.add(pointer.val);
            pointer = pointer.next;
        }

        // Remove nth from end
        list.remove(list.size() - n);
        if (list.isEmpty()) return null;

        // Rebuild list from array
        ListNode result = new ListNode(list.get(0));
        pointer = result;
        for (int i = 1; i < list.size(); i++) {
            pointer.next = new ListNode(list.get(i));
            pointer = pointer.next;
        }

        return result;
    }
}
