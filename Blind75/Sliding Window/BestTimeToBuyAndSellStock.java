/**
 * Problem: Best Time to Buy and Sell Stock (NeetCode Blind 75 - Easy)
 * Author: Steve Eckardt
 * Revision Date: August 8, 2025
 * Description: Finds the maximum profit from one buy-sell transaction by tracking the minimum price seen so far.
 * Time Complexity: O(n) — scans the array once.
 * Space Complexity: O(1) — only uses a few variables.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Track the lowest price seen so far
        int result = 0;                   // Track the max profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;         // Found a cheaper buy price
            } else {
                int current = price - minPrice; // Profit if sold today
                if (current > result) {
                    result = current;     // Update max profit if better
                }
            }
        }

        return result; // Maximum profit found
    }
}
