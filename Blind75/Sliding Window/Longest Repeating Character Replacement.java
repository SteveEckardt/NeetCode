/**
 * Problem: Longest Repeating Character Replacement (NeetCode Blind 75 - Medium)
 * Author: Steve Eckardt
 * Revision Date: October 3, 2025
 * Description: Finds the length of the longest substring that can be turned into all the same character with at most k replacements.
 * Time Complexity: O(n) — each character is processed at most twice.
 * Space Complexity: O(1) — fixed-size array for 26 uppercase letters.
 */

class Solution {

    // Optimized sliding window solution
    public int characterReplacement(String s, int k) {
        char[] cArray = s.toCharArray();
        char[] count = new char[26];   // Frequency of each letter
        int len = cArray.length;
        int maxCount = 0;              // Count of most frequent char in window
        int left = 0, result = 0;

        for (int right = 0; right < len; right++) {
            int c = cArray[right] - 'A';
            count[c]++;

            // Track the most frequent character count in the window
            if (count[c] > maxCount) maxCount = count[c];

            // If replacements exceed k, shrink window from left
            while (right - left + 1 - maxCount > k) {
                count[cArray[left++] - 'A']--;
            }

            // Update max window size
            if (result < right - left + 1) result = right - left + 1;
        }

        return result;
    }

    // Brute-force solution (for comparison)
    public int characterReplacement2(String s, int k) {
        int longest = 0, len = s.length();
        char[] cArray = s.toCharArray();

        // Try each starting position
        for (int left = 0; left < len - 1; left++) {
            int right = left, kUsed = 0;

            // Expand window while replacements allowed
            while (right < len && (cArray[left] == cArray[right] || kUsed < k)) {
                if (cArray[left] != cArray[right]) kUsed++;
                right++;

                // Track longest window seen
                if (right - left + k - kUsed > longest) longest = right - left + k - kUsed;
                if (longest >= len) return len; // Can't get longer than string
            }
        }

        return longest;
    }
}
