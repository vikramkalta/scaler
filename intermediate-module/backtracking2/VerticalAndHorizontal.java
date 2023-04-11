package backtracking2;

import java.util.ArrayList;

public class VerticalAndHorizontal {
    public static void main(String[] args) {
        int A = 3;
        int[][] b = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        int C = 2;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < b[i].length; j++) {
                innerList.add(b[i][j]);
            }
            B.add(innerList);
        }
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        int ans = 0;
        backtrack(B, 0, 0, C);
        for (int i = 0; i < B.size(); i++) {
            System.out.println(B.get(i));
        }
        return ans;
    }
    public static void backtrack(ArrayList<ArrayList<Integer>> A, int row, int col, int C) {
        for (int i = row; i < A.size(); i++) {
            for (int j = col; j < A.get(i).size(); j++) {
                // do operation.
                A.get(i).set(j, A.get(i).get(j) * -1);
                if (isLessThanC(A, i, j, C)) {
                    backtrack(A, i + 1, j + 1, C);
                } else {
                    // backtrack
                    A.get(i).set(j, A.get(i).get(j) * -1);
                }
            }
        }
    }
    public static boolean isLessThanC(ArrayList<ArrayList<Integer>> A, int row, int col, int C) {
        int sum = 0;
        // Check in the row.
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(row).get(i);
            if (sum > C) {
                return false;
            }
        }
        // Check in the col.
        sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i).get(col);
            if (sum > C) {
                return false;
            }
        }

        return true;
    }
}