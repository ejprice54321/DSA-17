import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    public static void solveQueens(char[][] board, List<char[][]> answers, int n, int i, int j, int qLeft){
        if (qLeft == 0){
            answers.add(copyOf(board));
            return;
        }
        if (isValid(board, i, j, n)) {
            board[i][j] = 'Q';
            solveQueens(board, answers, n, i+1, 0, qLeft-1);
            board[i][j] = '.';
        }
        if (j < n-1 && j >= 0){
            solveQueens(board, answers, n, i, j+1, qLeft);
        }
    }

    private static boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false; //check row
            if (board[row][i] == 'Q') return false; //check column
        }
        if (checkDiagonal(board, row, col)) return false; //check diagonal
        return true;
    }

    private static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }

    public static List<char[][]> nQueensSolutions(int n) {
        char[][] board = new char[n][n];
        List<char[][]> answers = new ArrayList<>(n);
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                        board[k][l] = '.';
                }
        }
        int i =0;
        int j=0;
        int qLeft = n;
        solveQueens(board, answers, n, i, j, qLeft);

        return answers;

    }

}
