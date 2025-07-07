/**
 * Problem: NeetCode - Matrix Depth-First Search (DFS)
 * Author: Steve Eckardt
 * Revision Date: July 6, 2025
 *
 * Recursively counts all valid paths from top-left to bottom-right in a grid using depth-first search with backtracking.
 *
 * Time Complexity:
 * - O(4^(m * n)) in the worst case (each cell may branch up to 4 directions without pruning)
 *
 * Space Complexity:
 * - O(m * n) for the visited matrix and call stack (in case of max-depth recursion)
 */

class Solution {
    // Entry point: count paths starting from (0, 0)
    public int countPaths(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return countPaths(grid, 0, 0, visited);
    }

    // Recursive DFS with backtracking
    public int countPaths(int[][] grid, int r, int c, boolean[][] visited) {
        // Out of bounds, already visited, or blocked cell
        if (r < 0 || c < 0 ||
            r >= grid.length || c >= grid[0].length ||
            visited[r][c] || grid[r][c] == 1)
            return 0;

        // Reached the bottom-right cell: valid path
        if (r == grid.length - 1 && c == grid[0].length - 1)
            return 1;

        visited[r][c] = true; // Mark cell as visited

        int count = 0;
        // Explore all 4 directions
        count += countPaths(grid, r + 1, c, visited); // Down
        count += countPaths(grid, r - 1, c, visited); // Up
        count += countPaths(grid, r, c + 1, visited); // Right
        count += countPaths(grid, r, c - 1, visited); // Left

        visited[r][c] = false; // Backtrack

        return count;
    }
}
