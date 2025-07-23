/**
 * Problem: Group Anagrams (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 23, 2025
 *
 * Description: Groups a list of strings into lists of anagrams using two strategies:
 *              (1) sorting each string to create the hash key,
 *              (2) using a character frequency array as the hash key.
 *
 * Time Complexity:
 *   - Sorted String Version: O(n * k log k), where n = number of strings, k = max string length
 *   - Frequency Array Version: O(n * k), avoids sorting by using fixed-size int arrays
 *
 * Space Complexity: O(n * k), for both versions (grouping and storing all strings)
 */

class Solution {

    // Version 1: Using sorted strings as hash map keys
    public List<List<String>> groupAnagramsSorted(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // Sort to normalize anagram forms
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    // Version 2: Using character frequency arrays as hash map keys
    public List<List<String>> groupAnagramsByCount(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] intkey = new int[26]; // Count letters a–z
            for (char c : str.toCharArray()) {
                intkey[c - 'a']++;
            }

            // Convert frequency array to a string key (e.g., "[1,0,1,...]")
            String key = Arrays.toString(intkey);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
