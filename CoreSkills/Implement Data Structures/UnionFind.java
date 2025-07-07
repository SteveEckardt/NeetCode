/**
 * Problem: NeetCode - Design Disjoint Set (Union-Find)  
 * Author: Steve Eckardt  
 * Revision Date: July 7, 2025  
 *
 * Efficiently tracks and merges disjoint sets using path compression and union-by-reference.
 *
 * Time Complexity:
 * - find(x) – O(1) 
 * - union(x, y) – O(1)
 * - isSameComponent(x, y) – O(1)
 * - getNumComponents() – O(1)
 *
 * Space Complexity: O(n) — stores parent pointers for each node
 */

class UnionFind {
    private int[] parent;
    private int components;

    // Initialize n components with each node as its own parent
    public UnionFind(int n) {
        parent = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Find the root of x (without path compression here)
    public int find(int x) {
        if (x == parent[x]) return x;
        return find(parent[x]);
    }

    // Check if x and y are in the same component
    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    // Union the components of x and y
    public boolean union(int x, int y) {
        if (isSameComponent(x, y)) return false;

        parent[find(y)] = find(x); // Merge trees
        components--;              // Reduce component count
        return true;
    }

    // Return the number of disjoint components
    public int getNumComponents() {
        return components;
    }
}
