package backtracking2;

import java.util.ArrayList;

public class UniquePaths3 {
    public static void main(String[] args) {
        int[][] a = {
        { 1, 0, 0, 0 },
        { 0, 0, 0, 0 },
        { 0, 0, 2, -1 },
        };
        // int[][] a = {
        //         { 1, 0, 0 },
        //         { 0, 0, 0 },
        //         { 0, 0, 2 },
        // };
        // int[][] a = {
        // { 1, 0 },
        // { 0, 0 },
        // { 0, 2 },
        // };
        // int[][] a = {
        //     { 1, 0, 0 },
        //     { 2, 0, 0 },
    // };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                innerList.add(a[i][j]);
            }
            A.add(innerList);
        }
        System.out.println(solve(A));
    }

    public static int totalVisitedCells = 0;

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int[] is = { -1, 0, 1, 0 };
        int[] js = { 0, 1, 0, -1 };
        int row = -1;
        int col = -1;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) == 1) {
                    row = i;
                    col = j;
                } else if (A.get(i).get(j) == 0) {
                    totalVisitedCells++;
                }
            }
        }
        uniquePath(A, is, js, row, col);
        return count;
    }

    public static int count = 0;

    public static void uniquePath(
            ArrayList<ArrayList<Integer>> visited,
            int[] is,
            int[] js,
            int row,
            int col) {
        if (checkBoundary(row, col, visited.size(), visited.get(0).size())) {
            return;
        }
        if (visited.get(row).get(col) == -1) {
            return;
        }
        if (visited.get(row).get(col) == 2) {
            if (totalVisitedCells == -1) {
                count++;
            }
            return;
        }

        if (visited.get(row).get(col) == 3) {
            return;
        }

        totalVisitedCells--;
        visited.get(row).set(col, 3);
        for (int k = 0; k < 4; k++) {
            int ki = row + is[k];
            int kj = col + js[k];
            uniquePath(visited, is, js, ki, kj);
        }
        visited.get(row).set(col, 0);
        totalVisitedCells++;
    }

    public static boolean checkBoundary(int i, int j, int row, int col) {
        return i < 0 || j < 0 || i >= row || j >= col;
    }
}
