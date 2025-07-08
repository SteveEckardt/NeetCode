import java.util.*;

/**
 * Problem: NeetCode - Dijkstra's Algorithm  
 * Author: Steve Eckardt  
 * Revision Date: July 7, 2025  
 *
 * Computes the shortest path distances from a source node to all other nodes in a weighted directed graph using Dijkstra's algorithm.
 *
 * Time Complexity: O((V + E) * log V) — due to priority queue operations  
 * Space Complexity: O(V + E) — for adjacency list, visited map, and priority queue
 */

class Solution {
    public Map<Integer, Integer> shortestPath(int n, 
                                              List<List<Integer>> edges, 
                                              int src) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        // Initialize distances and adjacency list
        for (int i = 0; i < n; i++) {
            distanceMap.put(i, -1); // -1 means "unvisited"
            adjList.put(i, new ArrayList<>());
        }

        // Populate adjacency list: edges are [from, to, weight]
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            int weight = edge.get(2);
            adjList.get(from).add(new int[]{to, weight});
        }

        // Min-heap prioritized by total weight to reach a node
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{src, 0});

        // Main Dijkstra loop
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int cost = current[1];

            // Skip if already visited
            if (distanceMap.get(node) > -1) continue;

            distanceMap.put(node, cost); // Lock in shortest distance

            // Add neighbors with cumulative cost to the heap
            for (int[] neighbor : adjList.get(node)) {
                int nextNode = neighbor[0];
                int nextCost = neighbor[1] + cost;
                minHeap.offer(new int[]{nextNode, nextCost});
            }
        }

        return distanceMap;
    }
}
