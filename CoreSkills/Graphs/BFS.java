/**
 * Problem: NeetCode - Matrix Breadth-First Search (BFS)
 * Author: Steve Eckardt
 * Revision Date: July 7, 2025
 *
 * Uses breadth-first search to find the shortest path from the top-left to the bottom-right of a grid with obstacles.
 *
 * Time Complexity:  O(m * n) — each cell is visited at most once
 * Space Complexity: O(m * n) — for the queue and visited matrix
 */

class Solution {

    public int shortestPath(int[][] grid) {
        final int ROW = grid.length;
        final int COL = grid[0].length;

        boolean[][] visited = new boolean[ROW][COL];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int count = 0; // Tracks the number of steps

        // Standard BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int[] current = queue.remove();

                // If we reach the bottom-right, return the step count
                if (current[0] == ROW - 1 && current[1] == COL - 1) {
                    return count;
                }

                // Explore four directions (up, down, left, right)
                int[][] neighbors = new int[][]{
                    {current[0] - 1, current[1]},
                    {current[0] + 1, current[1]},
                    {current[0], current[1] - 1},
                    {current[0], current[1] + 1}
                };

                for (int i = 0; i < 4; i++) {
                    int nr = neighbors[i][0];
                    int nc = neighbors[i][1];

                    // Validate neighbor and add to queue if walkable
                    if (nr >= 0 && nc >= 0 && nr < ROW && nc < COL &&
                        grid[nr][nc] == 0 && !visited[nr][nc]) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            count++; // Increment step level after processing a layer
        }
        return -1; // No valid path found
    }
}
