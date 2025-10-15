/**
 * Problem: Minimum Window Substring (NeetCode Blind 75 - Hard)
 * Author: Steve Eckardt
 * Revision Date: October 15, 2025
 * Description: Finds the smallest substring in s that contains all characters from t using a sliding window approach.
 * Time Complexity: O(n + m) — where n = length of s and m = length of t.
 * Space Complexity: O(k) — where k = number of unique characters in t.
 */

class Solution {
    public String minWindow(String s, String t) {
        
        if (t.isEmpty() || t.length() > s.length()) return "";

        // Frequency maps for target (t) and current window
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        String result = new String(s);

        // Build frequency map for target string t
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int have = 0, need = map.size(), len = s.length();
        char[] sArray = s.toCharArray();
        int left = 0, right = 0, resLen = Integer.MAX_VALUE;
        int[] res = {0, len};

        // Move left pointer to first relevant character
        while (left < len && !map.containsKey(sArray[left])) {
            left++;
            right++;
        }

        // Expand the window
        for (; right < len; right++) {
            
            char c = sArray[right];
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If current char count matches target count, increment 'have'
            if (map.containsKey(c) && window.get(c).equals(map.get(c))) have++;

            // Try shrinking the window when valid
            while (have == need) {
                
                if ((right - left + 1) < resLen) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = sArray[left];
                window.put(leftChar, window.get(leftChar) - 1);

                // If we lose a required char, window is no longer valid
                if (map.containsKey(leftChar) && window.get(leftChar) < map.get(leftChar))
                    have--;

                left++;
            }// end while
        }// end for

        // Return smallest valid window
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }// end minWindow
}// end Solution
