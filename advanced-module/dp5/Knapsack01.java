public class Knapsack01 {
    public static void main(String args[]) {
        int[] A = {60,100,120};
        int[] B = {10,20,30};
        int C = 50;
        // int[] A = { 6, 4, 5 };
        // int[] B = { 6, 5, 3 };
        // int C = 9;
        // int[] A = {10, 20, 30, 40};
        // int[] B = {12, 13, 15, 19};
        // int C = 10;
        // int[] A = {504, 449, 201, 459, 619, 581, 797, 799, 282, 590, 799, 10, 158,
        // 473, 623};
        // int[] B = {39, 93, 39, 80, 91, 58, 59, 92, 16, 89, 57, 12, 3, 35, 73};
        // int C = 56;
        System.out.println(solve(A, B, C));
    }

    public static int solve(int[] A, int[] B, int C) {
        int len = A.length;
        int[][] dp = new int[len + 1][C + 1];
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < C + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (j < B[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - B[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[len][C];
    }

    public static int solve1(int[] A, int[] B, int C) {
        int len = A.length;
        int[][] dp = new int[len][C + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < C + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = knapsack(A, B, C, len - 1, dp);
        return ans;
    }

    public static int knapsack(int[] A, int[] B, int C, int i, int[][] dp) {
        if (i < 0) {
            return 0;
        }
        if (C < B[i]) {
            return knapsack(A, B, C, i - 1, dp);
        }
        if (dp[i][C] != -1) {
            return dp[i][C];
        }
        int x = knapsack(A, B, C, i - 1, dp);
        int y = knapsack(A, B, C - B[i], i - 1, dp) + A[i];
        int z = Math.max(x, y);
        dp[i][C] = z;
        return z;
    }
}