import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        
        // Initialize an empty board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Lookup trackers for constant-time safety validation
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // For row + col
        boolean[] diag2 = new boolean[2 * n - 1]; // For row - col + n - 1
        
        // Kick off backtracking from the first row
        backtrack(0, n, board, solutions, cols, diag1, diag2);
        
        return solutions;
    }
    
    private void backtrack(int row, int n, char[][] board, List<List<String>> solutions,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // Base case: If we successfully placed queens in all rows, save the board
        if (row == n) {
            solutions.add(constructBoard(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;
            
            // If the column or either diagonal is under attack, skip this spot
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            
            // Place the queen
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            
            // Move to the next row
            backtrack(row + 1, n, board, solutions, cols, diag1, diag2);
            
            // Backtrack: Undo the placement for the next iterations
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
    
    // Helper method to convert the char array grid into the final list of strings
    private List<String> constructBoard(char[][] board) {
        List<String> listBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            listBoard.add(new String(board[i]));
        }
        return listBoard;
    }
}
