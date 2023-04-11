package backtracking2;
import java.util.ArrayList;

public class NQueens {
    public static void main(String[] args) {
        int A = 2;
        System.out.println(solveNQueens(A));
    }
    public static int count = 0;
    public static ArrayList<ArrayList<String>> ans = new ArrayList<>();
    public static ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            StringBuilder x = new StringBuilder();
            for (int j = 0; j < A; j++) {
                x.append('.');
            }
            board.add(x);
        }
        nQueens2(board, 0, A);
        return ans;
	}

    public static void nQueens2(ArrayList<StringBuilder> board, int col, int A) {
        if (col == A) {
            ArrayList<String> x = new ArrayList<>();
            for (int i = 0; i < A; i++) {
                x.add(new String(board.get(i)));
            }
            ans.add(x);
            return;
        }
        for (int i = 0; i < A; i++) {
            if (isValid(board, i, col)) {
                board.get(i).setCharAt(col, 'Q');
                nQueens2(board, col + 1, A);
                board.get(i).setCharAt(col, '.');
            }
        }
    }

    public static boolean nQueens(ArrayList<StringBuilder> board, int A, int start, int end) {
        // int ROWS, int COLS
        for (int i = start; i < A; i++) {
            for (int j = end; j < A; j++) {
                StringBuilder x = board.get(i);
                // if (x.charAt(j) == '.') {
                if (isValid(board, i, j)) {
                    x.setCharAt(j, 'Q');
                    // if (isValid(board, i, j) && nQueens(board, A, 0, 0)) {
                    //     count++;
                    //     return true;
                    // } else {
                    //     x.setCharAt(j, '.');
                    // }
                    if (nQueens(board, A, 0, 0)) {
                        count++;
                        return true;
                    } else {
                        x.setCharAt(j, '.');
                    }
                }
            }
        }
        return false;
    }
    public static boolean isValid(ArrayList<StringBuilder> board, int i, int j) {
        // Check all rows
        int len = board.size();
        for (int index = 0; index < len; index++) {
            if (index == i) {
                continue;
            }
            if (board.get(index).charAt(j) == 'Q') {
                return false;
            }
        }
        // Check all columns
        for (int index = 0; index < len; index++) {
            if (index == j) {
                continue;
            }
            if (board.get(i).charAt(index) == 'Q') {
                return false;
            }
        }
        // Diagonally top left to bottom right
        int _i = i;
        int _j = j;
        while( _i >= 0 && _j >= 0) {
            if (board.get(_i).charAt(_j) == 'Q' && i != _i && j != _j) {
                return false;
            }
            _i--;
            _j--;
        }
        _i = i;
        _j = j;
        while(_i < len && _j < len) {
            if (board.get(_i).charAt(_j) == 'Q' && i != _i && j != _j) {
                return false;
            }
            _i++;
            _j++;
        }
        _i = i;
        _j = j;
        // Diagonally top right to bottom left
        while(_i < len && _j >= 0) {
            if (board.get(_i).charAt(_j) == 'Q' && i != _i && j != _j) {
                return false;
            }
            _i++;
            _j--;
        }
        _i = i;
        _j = j;
        while(_i >= 0 && _j < len) {
            if (board.get(_i).charAt(_j) == 'Q' && i != _i && j != _j) {
                return false;
            }
            _i--;
            _j++;
        }
        return true;
    }
}