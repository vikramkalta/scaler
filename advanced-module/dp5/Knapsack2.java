public class Knapsack2 {
    public static void main(String args[]) {
        // int[] A = {6, 10, 12};
        // int[] B = {10, 20, 30};
        // int C = 50;
        // int[]  A = { 8, 5 };
        // int[] B = { 1, 20 };
        // int C = 17;
        int[]A={9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3};
        int[]B={22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24};
        int C = 513;
        System.out.println(solve(A, B, C));
    }

    public static int solve(int[] A, int[] B, int C) {
        int len = A.length;
        int totalProfit = 25000;
        int profit = 0;
        for (int i = 0; i < len; i++) {
            profit += A[i];
        }
        totalProfit = Math.min(totalProfit, profit);
        int[][] dp = new int[len + 1][totalProfit + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < totalProfit + 1; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = totalProfit; i >= 0; i--) {
            int x = knapsack2(A, B, C, len, i, dp);
            if (x <= C) {
                return i;
            }
        }
        // int ans = knapsack2(A, B, C, len, totalProfit, dp);
        return 0;
    }
    public static int knapsack2(int[] A, int[] B, int C, int i, int totalProfit, int[][] dp) {
        if (totalProfit == 0) {
            return 0;
        }
        if (i < 1) {
            return Integer.MAX_VALUE - 1000000;
        }
        if (dp[i][totalProfit]!=-1){
            return dp[i][totalProfit];
        }

        int ans = knapsack2(A, B, C, i - 1, totalProfit, dp);
        if (totalProfit >= A[i - 1]) {
            int x = knapsack2(A, B, C, i - 1, totalProfit - A[i - 1], dp) + B[i - 1];
            ans = Math.min(ans, x);
        }
        dp[i][totalProfit] = ans;
        return ans;
    }

    public static int solve1(int[] A, int[] B, int C) {
        int len = A.length;
        int profit = 0;
        for (int i = 0; i < len; i++) {
            profit += A[i];
        }
        int totalProfit = Math.min(25001, profit + 1);

        int[][] dp = new int[len + 1][totalProfit];
        // for (int i = 0; i < len + 1; i++) {
        //     for (int j = 0; j < totalProfit; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < totalProfit; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < totalProfit; j++) {
                if (j < A[i - 1] || C < B[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + B[i - 1]);
                }
            }
        }
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = totalProfit - 1; i >= 0; i--) {
            int x = dp[len][i];
            if (x <= C) {
                int y = C - x;
                if (minDiff >= y) {
                    minDiff = y;
                    ans = i;
                }
            }
        }
        // for (int i = 0; i < totalProfit; i++) {
        //     int x = dp[len][i];
        //     if (x > C) {
        //         return i - 1;
        //     }
        //     if (x == C) {
        //         return i;
        //     }
        // }
        return ans;
    }
}
