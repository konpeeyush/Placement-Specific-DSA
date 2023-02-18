public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (solve(i, j, word, board, 0)) return true;
            }
        }
        return false;
    }

    private static boolean solve(int i, int j, String word, char[][] board, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean ans = solve(i + 1, j, word, board, idx + 1) ||
                solve(i - 1, j, word, board, idx + 1) ||
                solve(i, j + 1, word, board, idx + 1) ||
                solve(i, j - 1, word, board, idx + 1);
        board[i][j] = temp;
        return ans;
    }
}
