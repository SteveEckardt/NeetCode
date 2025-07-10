/**
 * Problem: Unbounded Knapsack (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 10, 2025
 * 
 * Description: Given weights and profits of items, determine the maximum profit
 *              that can be obtained with an unbounded number of each item and a fixed capacity.
 * 
 * Time Complexity:
 *   - maximumProfit (DP): O(n * capacity)
 *   - brutus (BFS brute force): O(n^capacity) in the worst case due to exponential growth of combinations
 * 
 * Space Complexity:
 *   - maximumProfit (DP): O(capacity)
 *   - brutus (BFS brute force): O(n^capacity) for the queue storing all possible states
 */

class Solution {

    // Efficient dynamic programming solution
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity){
        int n = profit.size();
        int cap = capacity;
        int[] dp = new int[cap + 1];

        for (int i = 1; i <= n; i++) {
            int[] current = new int[cap + 1];
            int w = weight.get(i - 1);
            int p = profit.get(i - 1);

            for (int c = 1; c <= cap; c++) {
                if (w > c)
                    current[c] = dp[c];
                else
                    current[c] = Math.max(dp[c], current[c - w] + p);
            }

            dp = current;
        }

        return dp[cap];
    }

    // Helper class for profit-weight pairs
    class Item implements Comparable<Item> {
        int profit;
        int weight;

        public Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }

        public double getProfitPerWeight() {
            return (weight == 0) ? 0 : (1.0 * profit / weight);
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(this.getProfitPerWeight(), other.getProfitPerWeight());
			/**
			double ratioThis = this.getProfitPerWeight();
			double ratioOther = other.getProfitPerWeight();			
			if (ratioThis < ratioOther) {
				return -1;
			} else if (ratioThis > ratioOther) {
				return 1;
			} else {
				return 0;
			}	
			*/
        }
    }

    // Brute-force BFS solution (explores all combinations)
    public int brutus(List<Integer> profit, List<Integer> weight, int capacity) {
        Queue<Item> queue = new LinkedList<>();
        int result = 0;
        queue.add(new Item(0, 0));
        boolean addrow;

        do {
            addrow = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Item current = queue.remove();
                int cp = current.profit;
                int cw = current.weight;

                for (int j = 0; j < profit.size(); j++) {
                    int p = profit.get(j);
                    int w = weight.get(j);

                    if (w + cw <= capacity) {
                        addrow = true;
                        queue.add(new Item(p + cp, w + cw));
                        result = Math.max(result, p + cp);
                    }
                }
            }
        } while (addrow);

        return result;
    }

    /*
     * Attempted greedy solution using profit/weight ratio.
     * Incorrect for unbounded knapsack but left for experimentation.
     *
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity){
        int result = 0;
        int knapsack = 0;
        PriorityQueue<Item> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < profit.size(); i++) {
            maxHeap.add(new Item(profit.get(i), weight.get(i)));
        }

        while (!maxHeap.isEmpty()) {
            Item current = maxHeap.remove();
            int cp = current.profit;
            int cw = current.weight;

            while (knapsack + cw <= capacity) {
                knapsack += cw;
                result += cp;
            }
        }

        return result;
    }
    */
}
