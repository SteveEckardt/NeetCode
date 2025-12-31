/**
 * Problem: Replace Elements With Greatest Element on Right Side (NeetCode - Easy)
 * Author: Steve Eckardt
 * Revision Date: December 30, 2025
 * Description: Replaces each element with the greatest value to its right by scanning the array from right to left.
 * Time Complexity: O(n) — each element is processed once.
 * Space Complexity: O(n) — allocates a new result array.
 */
 
 class Solution {
    // inplace solution
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = -1;

        for(int i = len-1; i >= 0; i--){
            int current = arr[i];
            arr[i] = max;
            if(max < current) max = current;
        }
        return arr;
    }    
    
    public int[] replaceElements2(int[] arr) {
        int len = arr.length;
        int result[] = new int[len];
        int max = -1;
        for(int i = len-1; i >= 0; i--){
            result[i] = max;
            if(max < arr[i]) max = arr[i];
        }
        return result;
    }
}