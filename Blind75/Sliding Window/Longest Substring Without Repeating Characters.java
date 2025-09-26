/**
 * Problem: Longest Substring Without Repeating Characters (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: September 25, 2025
 * Description: Uses a sliding window with a HashSet to find the longest substring without duplicate characters.
 * Time Complexity: O(n) — each character is added and removed at most once.
 * Space Complexity: O(min(n, a)) — HashSet stores up to the smaller of string length or alphabet size.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); // Tracks unique characters in window
        int result = 0, left = 0, right = 0, len = s.length();

        // Expand window with right pointer
        while (right < len) {
            char r = s.charAt(right);

            // Shrink window until duplicate is removed
            while (set.contains(r)) {
                char l = s.charAt(left++);
                set.remove(l);
            }

            // Add current character to window
            set.add(r);
            right++;

            // Update maximum window size
            if (right - left > result) result = right - left;
        }

        return result;
    }
}
