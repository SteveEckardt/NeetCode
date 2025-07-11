/**
 * Problem: Kruskal's Algorithm (NeetCode)
 * Author: Steve Eckardt
 * Revision Date: July 11, 2025
 *
 * Description: Finds the minimum spanning tree (MST) of a connected undirected graph using Kruskal's algorithm.
 *
 * Time Complexity: O(E log E + E * α(V)), where E is the number of edges, V is the number of vertices,
 *                  and α is the inverse Ackermann function (from union-find)
 * Space Complexity: O(V + E), for the edge list, priority queue, and union-find structure
 */

class Solution {

    // Edge class, sorted by weight
    class Edge implements Comparable<Edge> {
        int w; // edge weight
        int v; // one endpoint
        int u; // other endpoint

        public Edge(int v, int u, int w) {
            this.v = v;
            this.u = u;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w); // Min-heap by weight
        }
    }

    // Union-Find (Disjoint Set Union) with path compression
    class UnionFind {
        private int[] parents;
        private int components;

        public UnionFind(int size) {
            parents = new int[size];
            components = size;
            for (int i = 1; i < size; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (x < 0 || x >= parents.length) return -1;
            if (x == parents[x]) return x;
            return parents[x] = find(parents[x]); // Path compression
        }

        public boolean isSame(int x, int y) {
			if (x < 0 || x >= parents.length) return false;
			if (y < 0 || y >= parents.length) return false;
            return find(x) == find(y);
        }

        public void union(int x, int y) {
			if (x < 0 || x >= parents.length) return;
			if (y < 0 || y >= parents.length) return;			
            if (isSame(x, y)) return;
            components--;
            // Union by smaller root value
            if (find(x) < find(y))
                parents[find(y)] = find(x);
            else
                parents[find(x)] = find(y);
        }

        public int getComponents() {
            return components;
        }
    }

    // Kruskal’s algorithm to return total weight of MST
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        int weight = 0;
        Queue<Edge> minheap = new PriorityQueue<>();

        // Load edges into priority queue
        for (List<Integer> edge : edges) {
            int v = edge.get(0), u = edge.get(1), w = edge.get(2);
            minheap.add(new Edge(v, u, w));
        }

        UnionFind union = new UnionFind(n);

        // Process edges in ascending order of weight
        while (union.getComponents() > 1 && !minheap.isEmpty()) {
            Edge edge = minheap.poll();
            if (!union.isSame(edge.u, edge.v)) {
                union.union(edge.u, edge.v);
                weight += edge.w;
            }
        }

        // If components remain, graph was disconnected
        return (union.getComponents() > 1) ? -1 : weight;
    }
}
