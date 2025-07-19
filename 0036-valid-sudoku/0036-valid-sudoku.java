class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] rows[] = new boolean[9][9];
        boolean[] columns[] = new boolean[9][9];
        boolean[] boxes[] = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int index = num - '1'; // Convert char to index
                    int boxIndex = (i / 3) * 3 + (j / 3); // Determine the box index

                    // Check if the number has already been seen in the current row, column, or box
                    if (rows[i][index] || columns[j][index] || boxes[boxIndex][index]) {
                        return false;
                    }

                    // Mark the number as seen
                    rows[i][index] = true;
                    columns[j][index] = true;
                    boxes[boxIndex][index] = true;
                }
            }
        }
        return true; // If all checks passed, the Sudoku is valid
    }
} 