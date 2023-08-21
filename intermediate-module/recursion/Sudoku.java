package recursion;
public class Sudoku {
    public static void main(String args[]) {
        char[][] A = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        try {
            solveSudoku(A);
        } catch (Exception e) {
            System.out.println();
        }
        System.out.println();
    }

    public static void solveSudoku(char[][] A) {
        char[][] B = new char[9][9];
        for (int i = 0 ; i < 9; i++) {
            for (int j = 0;j < 9; j++) {
                B[i][j] = A[i][j];
            }
        }
        solve(A, 0, 0, 0, B);
    }

    public static boolean solve(char[][] A, int ROW_START, int COL_START, int NUM, char[][] B) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (A[i][j] == '.') {
                    for (int k = NUM; k < 9; k++) {
                        int _k = k + 1;
                        if (checkValid(A, i, j, _k)) {
                            A[i][j] = (char)(_k + '0');
                            if (solve(A, ROW_START, COL_START, NUM, B)) {
                                return true;
                            } else {
                                A[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkValid(char[][] A, int row, int col, int num) {
        // column check
        for (int i = 0; i < 9; i++) {
            if (A[i][col] - '0' == num) {
                return false;
            }
        }
        // row check
        for (int i = 0; i < 9; i++) {
            if (A[row][i] - '0' == num) {
                return false;
            }
        }
        // block check
        for (int i = 0; i < 9; i++) {
            int r = ((row / 3) * 3) + (i / 3);
            int c = ((col / 3) * 3) + (i % 3);
            if (A[r][c] - '0' == num) {
                return false;
            }
        }
        return true;
    }
}