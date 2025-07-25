/**
 * Problem: Encode and Decode Strings (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 24, 2025
 *
 * Description: Encodes a list of strings into a single string, and decodes it back using length prefixes.
 *
 * Time Complexity: O(n), where n is the total number of characters in the list of strings
 * Space Complexity: O(n), for building the encoded string and storing the result list
 */

class Solution {

    // Encodes list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        // Step 1: Append the number of strings
        builder.append(strs.size()).append(':');

        // Step 2: Append each string's length
        for (String str : strs) {
            builder.append(str.length()).append(':');
        }

        // Step 3: Add total header length prefix (adjusted for its own length)
        int preLength = builder.length();
        preLength += String.valueOf(preLength + 1).length();
        builder = new StringBuilder().append(preLength).append(':').append(builder);

        // Step 4: Append all string contents
        for (String str : strs) {
            builder.append(str);
        }

        return builder.toString();
    }

    // Decodes the encoded string back into list of strings
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();

        // Step 1: Extract all integers from header using colon delimiter
        for (String s : str.split(":")) {
            try {
                lengths.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                // Skip non-integer tokens
            }
        }

        // Step 2: Extract body of encoded string (after full header)
        String words = str.substring(lengths.get(0) + 1);
        int start = 0;

        // Step 3: Reconstruct strings using recorded lengths
        for (int i = 2; i < lengths.get(1) + 2; i++) {
            int end = start + lengths.get(i);
            list.add(words.substring(start, end));
            start = end;
        }

        return list;
    }
}
