/**
 * Problem: Product of Array Except Self (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 25, 2025
 *
 * Description: Returns an array such that each element at index i is the product of all other elements in the input array except nums[i], without using division (except in one optional version).
 *
 * Time Complexity:
 *   - productExceptSelf: O(n)
 *   - productExceptSelf2: O(n)
 *   - productExceptSelf3: O(n)
 *
 * Space Complexity:
 *   - productExceptSelf: O(1) extra (excluding result array)
 *   - productExceptSelf2: O(n) extra (pre/post arrays)
 *   - productExceptSelf3: O(1) extra (but uses division and handles zero cases)
 */

class Solution {

    // Version 1: O(1) extra space (excluding result), uses inplace pre/post array
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int current = 1;

        // Pass 1: (pre-product) product of elements before current index
        for (int i = 0; i < len; i++) {
            result[i] = current;
            current *= nums[i];
        }

        current = 1;
        // Pass 2: (post-product) product of elements after current index
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= current;
            current *= nums[i];
        }

        return result;
    }

    // Version 2: Uses pre-product and post-product arrays
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];    // Product of elements before i
        int[] post = new int[len];   // Product of elements after i
        int[] result = new int[len];

        // Pass 1: pre-product array
        int current = 1;
        for (int i = 0; i < len; i++) {
            pre[i] = current * nums[i];
            current = pre[i];
        }

        // Pass 2: post-product array
        current = 1;
        for (int i = len - 1; i >= 0; i--) {
            post[i] = current * nums[i];
            current = post[i];
        }
        
        // Pass 3: multiply pre-product times post-product 
        for (int i = 0; i < len; i++) {
            int left = (i > 0) ? pre[i - 1] : 1;
            int right = (i < len - 1) ? post[i + 1] : 1;
            result[i] = left * right;
        }

        return result;
    }

    // Version 3: Division-based, handles edge case of zero(s)
    public int[] productExceptSelf3(int[] nums) {
        int len = nums.length;
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = 0;
        int[] result = new int[len];

        // Calculate total product excluding zeros
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            if (n != 0) {
                product *= n;
            } else {
                if (zeroCount == 1) return result; // More than one zero -> all zero result
                zeroCount++;
                zeroIndex = i;
            }
        }

        // If exactly one zero, only that index gets the product
        if (zeroCount == 1) {
            result[zeroIndex] = product;
            return result;
        }

        // No zeros: use division for each element
        for (int i = 0; i < len; i++) {
            result[i] = product / nums[i];
        }

        return result;
    }
}
