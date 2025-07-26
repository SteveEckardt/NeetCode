/**
 * Problem: Longest Consecutive Sequence (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 26, 2025
 *
 * Description: Finds the length of the longest consecutive elements sequence in an unsorted array.
 *
 * Time Complexity: O(n), where n is the number of elements in the array
 * Space Complexity: O(n), for storing elements in a HashSet
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Add all elements to the set and track global min/max
        for (int n : nums) {
            set.add(n);
            if (n < min) min = n;
            if (n > max) max = n;
        }

        int longest = 1;
        int current = 1;

        // Check consecutive sequence from min to max
        for (int i = min; i <= max; i++) {
            if (set.contains(i) && set.contains(i - 1)) {
                current++; // Extend current sequence
            } else {
                if(current > longest) longest = current;
                current = 1; // Reset for new potential sequence
            }
        }

        return Math.max(current, longest);
    }
}


/**
 * Problem: Longest Consecutive Sequence (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 26, 2025
 *
 * Description: Uses TreeSet to maintain sorted order and find the longest consecutive sequence.
 *
 * Time Complexity: O(n log n), due to TreeSet insertions and ordered iteration
 * Space Complexity: O(n), for storing unique elements
 */
 class Solution2 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new TreeSet<>();
        
        // Add all elements to the set
        for(int n: nums){
            set.add(n);
        }
        
        int longest = 1;
        int current = 1;
        
        // Check consecutive sequence
        for(int n: set){
            if(set.contains(n-1)){
                current++;
            }else{
                if(longest < current) longest = current;
                current = 1;
            }
        }

        return Math.max(longest, current);
    }
}

