/**
 * Problem: Prim's Algorithm (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 11, 2025
 *
 * Description: Finds the weight of the Minimum Spanning Tree (MST) in an undirected weighted graph using Prim's algorithm.
 *
 * Time Complexity: O(E log V), where E is the number of edges and V is the number of vertices
 * Space Complexity: O(V + E), for adjacency list, priority queue, and visited set
 */

class Solution {

    // Edge class with priority based on weight
    class Edge implements Comparable<Edge> {
        int weight;
        int to;

        public Edge(int to, int weight) {
            this.weight = weight;
            this.to = to;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight); // Min-heap behavior
        }
    }

    // Prim's algorithm to find the total weight of the MST
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        int weight = 0;

        // Build adjacency list from edge list
        Map<Integer, List<Edge>> adj = new HashMap<>();
        for (List<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // Start from node 0
        int current = 0;
        visited.add(current);
        queue.addAll(adj.get(current));

        // Add edges to MST while not all nodes are visited
        while (visited.size() < n && !queue.isEmpty()) {
            Edge temp = queue.poll();

            // Skip visited nodes
            while (!queue.isEmpty() && visited.contains(temp.to)) {
                temp = queue.poll();
            }

            if (!visited.contains(temp.to)) {
                current = temp.to;
                weight += temp.weight;
                visited.add(current);
                queue.addAll(adj.get(current)); // Add new edges
            }
        }

        // If not all nodes are visited, graph is disconnected
        return (visited.size() < n) ? -1 : weight;
    }
}
