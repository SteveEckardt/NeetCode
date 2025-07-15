/**
 * Problem: Topological Sort (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 15, 2025
 *
 * Description: Performs a topological sort on a directed graph using DFS with cycle detection.
 *
 * Time Complexity: O(V + E), where V is the number of nodes and E is the number of edges
 * Space Complexity: O(V + E), for the adjacency list and auxiliary data structures
 */

class Solution {

    // Helper class to encapsulate graph state and traversal metadata
    private static class DFSContext {
        Map<Integer, List<Integer>> adj;
        boolean[] visited;// Tracks fully processed nodes
        boolean[] visiting;// Tracks nodes in the current DFS path
        List<Integer> result;

        public DFSContext(int n, int[][] edges) {
            // Build adjacency list
            adj = new HashMap<>();
            for (int i = 0; i < n; i++) {
                adj.put(i, new ArrayList<>());
            }
            // Populate the adjacency list
            for (int[] edge : edges) {
                ctx.adj.get(edge[0]).add(edge[1]);
            }            
            visited = new boolean[n];
            visiting = new boolean[n];
            result = new ArrayList<>();
        }
    }

    // Main function to perform topological sort
    public List<Integer> topologicalSort(int n, int[][] edges) {
        DFSContext ctx = new DFSContext(n, edges);

        // Run DFS on all nodes (in case the graph is disconnected)
        for (int i = 0; i < n; i++) {
            if (!dfs(i, ctx)) {
                return new ArrayList<>(); // Cycle detected
            }
        }

        // Reverse the result to get the topological order
        Collections.reverse(ctx.result);
        return ctx.result;
    }

    // DFS helper that detects cycles and builds the topological order
    private boolean dfs(int node, DFSContext ctx) {
        if (ctx.visited[node]) return true;      // Node already processed
        if (ctx.visiting[node]) return false;    // Cycle detected

        ctx.visiting[node] = true; // Mark node as being visited

        for (int neighbor : ctx.adj.get(node)) {
            if (!dfs(neighbor, ctx)) return false; // Propagate cycle detection
        }

        ctx.visiting[node] = false;  // Unmark after visiting all neighbors
        ctx.visited[node] = true;    // Mark as fully processed
        ctx.result.add(node);        // Postorder addition for topological sort

        return true;
    }
}
