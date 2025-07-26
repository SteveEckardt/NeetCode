/**
 * Problem: Valid Palindrome (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 25, 2025
 * 
 * One-sentence explanation:
 *   Checks whether a given string is a valid palindrome by ignoring spaces,
 *   punctuation, and case sensitivity.
 * 
 * Time Complexity: O(n) – where n is the length of the input string
 * Space Complexity: O(1) – in-place comparison after cleanup (ignoring regex temp cost)
 */

class Solution {
    public boolean isPalindrome(String s) {
        // Convert to lowercase and remove spaces and punctuation
        s = s.toLowerCase()
             .replaceAll("\\s+", "")        // Remove whitespace
             .replaceAll("\\p{Punct}", ""); // Remove punctuation
        
        int left = 0;
        int right = s.length() - 1;

        // Two-pointer check from both ends
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false; // Mismatch found
        }

        return true; // All characters matched
    }
}
