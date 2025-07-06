import java.util.*;

/**
 * Problem: NeetCode - Design Graph  
 * Author: Steve Eckardt  
 * Revision Date: July 6, 2025  
 *
 * Implements a directed graph using an adjacency list, with support for edge manipulation and DFS-based path checking.
 *
 * Time Complexity:
 * - addEdge(src, dst)     => O(1) average
 * - removeEdge(src, dst)  => O(1) average
 * - hasPath(src, dst)     => O(V + E) in worst case (DFS traversal)
 */

class Graph {

    // Adjacency list: maps each node to its outgoing edges
    private HashMap<Integer, HashSet<Integer>> adjList;

    // Initializes an empty graph
    public Graph() {
        adjList = new HashMap<>();
    }

    // Adds a directed edge from src to dst
    public void addEdge(int src, int dst) {
        adjList.putIfAbsent(src, new HashSet<>());
        adjList.putIfAbsent(dst, new HashSet<>());
        adjList.get(src).add(dst);
    }

    // Removes the edge from src to dst if it exists
    public boolean removeEdge(int src, int dst) {
        if (adjList.containsKey(src) && adjList.get(src).contains(dst)) {
            adjList.get(src).remove(dst);
            return true;
        }
        return false;
    }

    // Checks if there is a path from src to dst using DFS
    public boolean hasPath(int src, int dst) {
        HashSet<Integer> visited = new HashSet<>();
        return hasPath(visited, src, dst);
    }

    // Helper method for DFS path search
    private boolean hasPath(HashSet<Integer> visited, int src, int dst) {
        if (src == dst) return true;

        if (adjList.containsKey(src)) {
            visited.add(src);
            for (int neighbor : adjList.getOrDefault(src, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    if (hasPath(visited, neighbor, dst)) return true;
                }
            }
        }
        return false;
    }
}
