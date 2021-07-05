import java.util.ArrayList;

public class Sudoku {
    public static void main(String args[]) {
        String[] arr = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
                "...419..5", "....8..79" };
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Character> innerArr = new ArrayList<>();
            String curr = arr[i];
            for (int j = 0; j < curr.length(); j++) {
                char c = curr.charAt(j);
                innerArr.add(c);
            }
            A.add(innerArr);
        }
        // System.out.println(solve(A));
        solve(A);
        // perm("abc", 0, 2);
    }

    public static void solveSudoku(ArrayList<ArrayList<Character>> A) {
        // int len = A.size();
        solve(A);
        // sudoku(A, 0, 0, 0);
        for (int i = 0; i < 9; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                s.append(A.get(i).get(j));
            }
            System.out.print(s + " ");
        }
        // System.out.println(A);
    }

    public static boolean solve(ArrayList<ArrayList<Character>> A) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = A.get(i).get(j);
                if (curr == '.') {
                    for (int k = 0; k < 9; k++) {
                        if (checkIfValid(A, k + 1, i, j)) {
                            char newChar = Character.forDigit(k + 1, 10);
                            A.get(i).set(j, newChar);
                            if (solve(A)) {
                                // System.out.println(A.get(i));
                                return true;
                            } else {
                                A.get(i).set(j, '.');
                                // System.out.println(A.get(i));
                            }
                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }

    public static void sudoku(ArrayList<ArrayList<Character>> A, int i, int j, int x) {
        // base case
        if (i == 8 && j == 8) {
            // System.out.println(A);
            return;
        }
        if (j >= 9) {
            j = 0;
            i++;
            sudoku(A, i, j, x);
            return;
        }
        char c = A.get(i).get(j);
        if (c != '.') {
            if (j >= 9) {
                i++;
                j = 0;
            } else {
                j++;
            }
            sudoku(A, i, j, x);
        } else {
            boolean isFound = false;
            x = 0;
            while (x < 9) {
                boolean valid = checkIfValid(A, x + 1, i, j);
                if (valid) {
                    isFound = true;
                    char newChar = Character.forDigit(x + 1, 10);
                    A.get(i).set(j, newChar);
                    // sudoku(A, i, j + 1, x);
                    // sudoku(A, i, j, x);
                }
                x++;
            }
            // if (!isFound) {
            // // System.out.println(i + " " + j);
            // // A.get(i).set(j, '.');
            // // sudoku(A, i, j - 1, 0);
            // }
            sudoku(A, i, j + 1, 0);

        }
    }

    public static boolean checkIfValid(ArrayList<ArrayList<Character>> A, int term, int i, int j) {
        boolean isValid = true;
        // Check row.
        int row = 0, col = 0;
        while (row < 9) {
            char curr = A.get(i).get(row);
            int _curr = curr - '0';
            if (_curr == term) {
                isValid = false;
                break;
            }
            row++;
        }
        // Check column.
        while (col < 9) {
            char curr = A.get(col).get(j);
            int _curr = curr - '0';
            if (_curr == term) {
                isValid = false;
                break;
            }
            col++;
        }
        // Check 3*3 box
        int count = 0;
        int initR = (i / 3) * 3;
        int r = initR;
        int initC = (j / 3) * 3;
        int c = initC;
        while (count < 9) {
            char curr = A.get(r).get(c);
            int _curr = curr - '0';
            if (_curr == term) {
                isValid = false;
                break;
            }
            count++;
            r = initR + (count / 3);
            c = initC + (count % 3);
        }

        return isValid;
    }

    // Brute force
    public static void solve1(ArrayList<ArrayList<Character>> A) {
        int len = A.size();
        for (int i = 0; i < len; i++) {
            ArrayList<Character> curr = A.get(i);
            for (int j = 0; j < len; j++) {
                char ch = A.get(i).get(j);
                if (ch != '.') {
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    // check if number is present
                    int n = k + 1;
                    int horizontal = Character.valueOf(A.get(i).get(j));
                    int vertical = Character.valueOf(A.get(j).get(i));
                    int boxI = i + (j / 3);
                    int boxJ = j + (j % 3);
                    int box = Character.valueOf(A.get(boxI).get(boxJ));
                    if (n != horizontal && n != vertical && n != box) {
                        String nc = Integer.toString(n);
                        A.get(i).set(j, nc.charAt(0));
                        break;
                    }
                }
            }
        }
    }

    public static void perm(String s, int start, int end) {
        if (start == end) {
            System.out.println(s);
        } else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                perm(s, start + 1, end);
                // s = swap(s, start, i);
            }
        }
    }

    public static String swap(String s, int i, int j) {
        char temp = s.charAt(j);
        char curr = s.charAt(i);
        char[] charA = s.toCharArray();
        charA[i] = temp;
        charA[j] = curr;
        return String.valueOf(charA);
    }
}
