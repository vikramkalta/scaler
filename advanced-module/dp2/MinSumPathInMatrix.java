import java.util.ArrayList;

public class MinSumPathInMatrix {
    public static void main(String args[]) {
        int[][] arr = { { 1, 3, 2 }, { 4, 3, 1 }, { 5, 6, 1 } };

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerArr.add(arr[i][j]);
            }
            A.add(innerArr);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                innerArr.add(-1);
            }
            dp.add(innerArr);
        }
        int prefixSum = 0;
        for (int i = 0; i < cols; i++) {
            int curr = A.get(0).get(i);
            prefixSum += curr;
            A.get(0).set(i, prefixSum);
        }

        prefixSum = 0;
        for (int i = 0; i < rows; i++) {
            int curr = A.get(i).get(0);
            prefixSum += curr;
            A.get(i).set(0, prefixSum);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int curr = A.get(i).get(j);
                int up = A.get(i - 1).get(j);
                int left = A.get(i).get(j - 1);
                int min = Math.min(curr + up, curr + left);
                A.get(i).set(j, min);
            }
        }
        return A.get(rows - 1).get(cols - 1);
    }

    public static int solve1(ArrayList<ArrayList<Integer>> A) {
        int ans = 0;
        int rows = A.size();
        int cols = A.get(0).size();
        // int min = Integer.MAX_VALUE;
        ans = minSumPath(A, 0, 0, rows, cols);
        return ans;
    }

    public static int minSumPath(ArrayList<ArrayList<Integer>> A, int i, int j, int rows, int cols) {
        if (i >= rows) {
            return 0;
        }
        if (j >= cols) {
            return 0;
        }
        int ans = 0;
        int currX = A.get(i).get(j);
        int x = minSumPath(A, i, j + 1, rows, cols) + currX;
        int currY = A.get(i).get(j);
        int y = minSumPath(A, i + 1, j, rows, cols) + currY;
        ans = x + y;
        // if (min > ans) {
        // min = ans;
        // }
        return ans;
    }
}