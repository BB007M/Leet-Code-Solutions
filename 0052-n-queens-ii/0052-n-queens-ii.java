class Solution {
    private int count = 0;
    private boolean[] cols;
    private boolean[] diag1; // For row + col
    private boolean[] diag2; // For row - col

    public int totalNQueens(int n) {
        count = 0;
        cols = new boolean[n];
        // An N x N board has 2N - 1 diagonals
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        
        backtrack(0, n);
        return count;
    }

    private void backtrack(int row, int n) {
        // Base case: All queens are successfully placed
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // Shift the index for negative diagonals to avoid negative array indices
            int d1 = row + col;
            int d2 = row - col + (n - 1);

            // If the column or diagonals are already attacked, skip this position
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place the queen (set flags)
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // Move to the next row
            backtrack(row + 1, n);

            // Backtrack (remove the queen and reset flags)
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
