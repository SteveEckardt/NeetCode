/**
 * Problem: Valid Sudoku (NeetCode - Medium)
 * Author: Steve Eckardt
 * Revision Date: January 11, 2026
 * Description: Validates a partially filled Sudoku board by checking rows, columns, and 3×3 subgrids for duplicate digits.
 * Time Complexity: O(1) — fixed 9×9 board with constant checks.
 * Space Complexity: O(1) — uses constant-sized boolean arrays.
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] row = new boolean[10];
        boolean[] column = new boolean[10];

        // Check each row and column
        for (int i = 0; i < 9; i++) {
            Arrays.fill(row, false);
            Arrays.fill(column, false);

            for (int j = 0; j < 9; j++) {
                // Row check
                if (board[i][j] != '.') {
                    int x = board[i][j] - '0';
                    if (row[x]) return false;
                    row[x] = true;
                }

                // Column check
                if (board[j][i] != '.') {
                    int x = board[j][i] - '0';
                    if (column[x]) return false;
                    column[x] = true;
                }
            }
        }

        // Check each 3×3 subgrid
        for (int i = 0; i < 7; i += 3)
            for (int j = 0; j < 7; j += 3) {
                Arrays.fill(row, false);

                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++)
                        if (board[i + k][j + l] != '.') {
                            int x = board[i + k][j + l] - '0';
                            if (row[x]) return false;
                            row[x] = true;
                        }
            }

        return true;
    }
}
