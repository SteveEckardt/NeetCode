/**
 * Problem: Merge K Sorted Lists (NeetCode Blind 75 - Hard)
 * Author: Steve Eckardt
 * Revision Date: October 6, 2025
 * Description: Merges k sorted linked lists into one sorted list using a HashMap and custom ListManager.
 * Time Complexity: O(n log n) — sorting unique node values.
 * Space Complexity: O(n) — stores nodes grouped by value in a map.
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

// Helper class to track the head and tail of each list segment
class ListManager {
    ListNode head;
    ListNode tail;
    public ListManager(ListNode node) {
        head = node;
        tail = node;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Map<Integer, ListManager> map = new HashMap<>();

        // Group nodes by their values and using val as map key
        for (ListNode node : lists) {
            while (node != null) {
                int value = node.val;

                // Append node to existing map group 
                if (map.containsKey(value)) {
                    ListManager current = map.get(value);
                    current.tail.next = node;
                    current.tail = current.tail.next;
                // Create a new map group
                } else {
                    map.put(value, new ListManager(node));
                }

                node = node.next;
            }
        }

        // Sort the keys (node values) to merge in order
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);

        ListManager result = null;

        // Concatenate all sorted list groups
        for (Object obj : keys) {
            int key = (Integer) obj;
            if (result == null) {
                result = map.get(key);
            } else {
                result.tail.next = map.get(key).head;
                result.tail = map.get(key).tail;
            }
        }

        // Return merged sorted list
        return (result == null) ? null : result.head;
    }
}
