import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        solveSudoku(board);
        System.out.println("Solved Sudoku: ");
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private static void solveSudoku(int[][] board) {
        int n = board.length;
        if (board == null || n == 0) return;
        solve(board);
    }

    private static boolean solve(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
//                Check for empty col
                if (board[i][j] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (isValid(board, i, j, val)) {
                            board[i][j] = val;

                            if (solve(board)) return true;
                            else board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
//            Check row
            if (board[i][col] != 0 && board[i][col] == val) return false;
//            Check col
            if (board[i][col] != 0 && board[row][i] == val) return false;
//            Check within 3x3
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) return false;
        }
        return true;
    }
}
