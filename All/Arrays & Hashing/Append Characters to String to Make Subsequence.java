/**
 * Problem: Append Characters to String to Make Subsequence (NeetCode - Arrays & Hashing)
 * Author: Steve Eckardt
 * Revision Date: January 3, 2026
 * Description: Determines how many characters must be appended to s so that t becomes a subsequence of s.
 * Time Complexity: O(n + m) — n = length of s, m = length of t.
 * Space Complexity: O(n + m) — uses character arrays for both strings.
 */

class Solution {
    public int appendCharacters(String s, String t) {
        // If t already appears fully in s, no characters are needed
        if (s.contains(t)) return 0;

        char[] sChar = s.toCharArray();
        int slen = sChar.length;
        int sPointer = 0;

        char[] tChar = t.toCharArray();
        int tlen = tChar.length;     
        int tPointer = 0;   

        // Two-pointer scan to match t as a subsequence of s
        while (sPointer < slen && tPointer < tlen) {
            if (sChar[sPointer++] == tChar[tPointer])
                tPointer++;
        }

        // Remaining characters in t must be appended
        return tlen - tPointer;
    }
}
