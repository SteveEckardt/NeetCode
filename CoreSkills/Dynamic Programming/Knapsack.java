/**
 * NeetCode 0/1 Knapsack Problem
 * Author: Steve Eckardt
 * Revision Date: July 9
 *
 * Given a list of profits and corresponding weights, determine the maximum profit 
 * that can be achieved without exceeding a given weight capacity.
 *
 * maximumProfit - DP solution using 2D array
 * - Time Complexity: O(n * capacity)
 * - Space Complexity: O(n * capacity)
 *
 * brutus - Brute-force breadth-style building
 * - Time Complexity: O(n^2)
 * - Space Complexity: O(n^2) 
 */

class Solution {

    // Dynamic Programming approach to 0/1 Knapsack
    public int maximumProfit(List<Integer> profit, 
                             List<Integer> weight, 
                             int capacity) {

        int[][] array = new int[profit.size() + 1][capacity + 1];

        for (int i = 1; i <= profit.size(); i++) {
            int w = weight.get(i - 1); // current item's weight
            int v = profit.get(i - 1); // current item's profit

            for (int j = 1; j <= capacity; j++) {
                int exclude = array[i - 1][j]; // don't take item
                int include = 0;
                if (j >= w) include = array[i - 1][j - w] + v; // take item
                array[i][j] = Math.max(include, exclude); // take max
            }
        }
        return array[profit.size()][capacity]; // max profit at full capacity
    }

    // Helper class to store weight-profit pairs
    class Item {
        int weight;
        int profit;

        public Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }
    }

    // Brute-force BFS-style simulation (inefficient but illustrative)
    public int brutus(List<Integer> profit, 
                      List<Integer> weight, 
                      int capacity) {

        List<Item> row = new ArrayList<>();
        row.add(new Item(0, 0)); // base case: no items selected
        int result = 0;

        for (int i = 0; i < profit.size(); i++) {
            int size = row.size();
            for (int j = 0; j < size; j++) {
                Item current = row.remove(0);
                row.add(current); // keep existing state
                int load = current.weight + weight.get(i);
                if (load <= capacity) {
                    int gain = current.profit + profit.get(i);
                    row.add(new Item(gain, load)); // try taking the item
                    result = Math.max(result, gain); // track max profit
                }
            }
        }
        return result;
    }
}
