/**
 * Problem: Score of a String (NeetCode - Easy)
 * Author: Steve Eckardt
 * Revision Date: December 30, 2025
 * Description: Computes the total score by summing absolute differences between adjacent characters in a string.
 * Time Complexity: O(n) — iterates through the string once.
 * Space Complexity: O(1) — constant extra space (char array version uses fixed memory).
 */

class Solution {

    public int scoreOfString(String s) {
        int result = 0;
        int len = s.length();
        // Convert string to char array for direct access
        char[] str = s.toCharArray(); 

        // Sum absolute differences of adjacent characters
        for (int i = 1; i < s.length(); i++) {
            result += Math.abs(str[i] - str[i - 1]);
        }
        return result;
    }

    public int scoreOfString2(String s) {
        int result = 0;

        // Same logic using charAt instead of a char array
        for (int i = 1; i < s.length(); i++) {
            result += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return result;
    }
}
