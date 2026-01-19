class Solution {

  int rows, cols;

  // Main function
  public int maxSideLength(int[][] grid, int limit) {

      rows = grid.length;
      cols = grid[0].length;

      // Prefix sum matrix
      int[][] prefix = new int[rows + 1][cols + 1];

      // Build prefix sums
      for (int r = 1; r <= rows; r++) {
          for (int c = 1; c <= cols; c++) {
              prefix[r][c] =
                      prefix[r - 1][c]
                    + prefix[r][c - 1]
                    - prefix[r - 1][c - 1]
                    + grid[r - 1][c - 1];
          }
      }

      int left = 0;
      int right = Math.min(rows, cols);
      int answer = 0;

      // Binary search on square size
      while (left <= right) {
          int size = left + (right - left) / 2;

          if (existsValidSquare(prefix, size, limit)) {
              answer = size;
              left = size + 1;
          } else {
              right = size - 1;
          }
      }

      return answer;
  }

  // Check if any square of given size satisfies threshold
  private boolean existsValidSquare(int[][] prefix, int size, int limit) {

      for (int r = size; r <= rows; r++) {
          for (int c = size; c <= cols; c++) {

              int squareSum =
                      prefix[r][c]
                    - prefix[r - size][c]
                    - prefix[r][c - size]
                    + prefix[r - size][c - size];

              if (squareSum <= limit) {
                  return true;
              }
          }
      }
      return false;
  }
}