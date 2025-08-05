/**
 * Problem: Valid Parentheses (NeetCode 150 - Easy)
 * Author: Steve Eckardt
 * Revision Date: August 5, 2025
 * Description: Checks if an input string has valid matching and properly nested parentheses.
 * Time Complexity: O(n) — each character is processed once.
 * Space Complexity: O(n) — in the worst case, all characters are added to the stack.
 */
class Solution {
    public boolean isValid(String s) {
        // Quick fail: odd-length strings can't be valid
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                // No opening bracket to match
                if (stack.isEmpty()) return false;

                char open = stack.pop();

                // Check if closing matches last open
                switch (c) {
                    case '}':
                        if (open != '{') return false;
                        break;
                    case ']':
                        if (open != '[') return false;
                        break;
                    case ')':
                        if (open != '(') return false;
                        break;
                    default:
                        return false; // invalid character
                }
            }
        }

        // Stack should be empty if all brackets matched
        return stack.isEmpty();
    }
}
