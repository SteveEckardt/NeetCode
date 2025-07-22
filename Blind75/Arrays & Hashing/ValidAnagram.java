/**
 * Problem: Valid Anagram (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 22, 2025
 *
 * Description: Checks whether two strings are anagrams of each other using a character frequency array.
 *
 * Time Complexity: O(n), where n is the length of the strings
 * Space Complexity: O(1), since the frequency array is fixed size (26)
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false; // Strings of different lengths can't be anagrams

        int[] count = new int[26]; // Frequency count for lowercase letters

        // Increment count for s and decrement for t in a single pass
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, strings are anagrams
        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
    }
}
