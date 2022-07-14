public class RectangleSum {
    public static void main(String args[]) {
        // int[][] A = { { 1, 3, -2 }, { 1, 4, 6 }, { -4, -2, 1 } };
        int[][] A = {
        { 1, 2, -1, -4, -20 },
        { -8,
        -3, 4, 2,
        1 }, // -4 --- -4-(-8)=4
        { 3,
        8, 10, 1,
        3 }, // 25 --- 25-3=22
        { -4,
        -1, 1, 7,
        -6 }, // -3 --- -3-(-4)=1
        };
        System.out.println(solve(A));
    }

    public static int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int maxAns = Integer.MIN_VALUE;

        for (int i = 0; i < cols; i++) {
            int[] rowSum = new int[rows];
            for (int k = i; k < cols; k++) {
                for (int j = 0; j < rows; j++) {
                    if (k - i == 0) {
                        rowSum[j] = A[j][k];
                    } else {
                        rowSum[j] = A[j][k] + rowSum[j];
                    }
                }
                // sum by kadane's algo
                int sum = 0;
                int maxSum = 0;
                for (int j = 0; j < rows; j++) {
                    if (sum + rowSum[j] > 0) {
                        sum += rowSum[j];
                    } else {
                        sum = 0;
                    }
                    maxSum = Math.max(sum, maxSum);
                }
                maxAns = Math.max(maxAns, maxSum);
            }
        }
        return maxAns;
    }

    public static int solve1(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[rows][cols];
        dp[0][0] = A[0][0];
        for (int i = 1; i < rows; i++) {
            A[i][0] = A[i][0] + A[i - 1][0];
        }
        for (int i = 1; i < cols; i++) {
            A[0][i] = A[0][i] + A[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int x = A[i][j - 1];
                int y = A[i - 1][j];
                int z = A[i - 1][j - 1];
                int currSum = x + y - z + A[i][j];
                // A[i][j] = Math.max(currSum, A[i][j]);
                A[i][j] = currSum;
                if (currSum > max) {
                    max = currSum;
                }
                // max = Math.max(max, currSum);
            }
        }
        return max;
    }
}