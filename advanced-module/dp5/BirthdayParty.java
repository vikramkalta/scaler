public class BirthdayParty {
    public static void main(String args[]) {
        // int[] A = {2, 4, 6};
        // int[] B = {2, 1, 3};
        // int[] C = {2, 5, 3};
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {3, 2, 4, 1};
        int[] C = {1, 2, 5, 10};
        System.out.println(solve(A, B, C));
    }

    public static int solve(final int[] A, final int[] B, final int[] C) {
        int len = B.length;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int cap = A[i];

            int[][] dp = new int[len][cap + 1];
            for (int j = 0; j < len; j++) {
                dp[j][0] = 0;
            }
            for (int j = 0; j < len; j++) {
                for (int k = 1; k < cap + 1; k++) {
                    dp[j][k] = -1;
                }
            }

            for (int j = 1; j < cap + 1; j++) {
                if (j < B[0]) {
                    dp[0][j] = -1;
                } else {
                    int x = dp[0][j - B[0]];
                    if (x != -1) {
                        dp[0][j] = x + C[0];
                    }
                }
            }

            for (int j = 1; j < len; j++) {
                for (int k = 1; k < cap + 1; k++) {
                    if (k < B[j]) {
                        if (dp[j - 1][k] != -1) {
                            dp[j][k] = dp[j - 1][k];
                        }
                    } else {
                        int ans = Integer.MAX_VALUE;
                        int x1 = dp[j][k - B[j]];
                        int y1 = dp[j - 1][k];
                        
                        if (x1 != -1) {
                            ans = Math.min(x1 + C[j], ans);
                        }
                        if (y1 != -1) {
                            ans = Math.min(ans, y1);
                        }
                        if (ans != Integer.MAX_VALUE) {
                            dp[j][k] = ans;
                        } else {
                            dp[j][k] = -1;
                        }
                    }
                }
            }

            int ans = dp[len - 1][cap];
            sum += ans;
        }
        return sum;
    }

    public static int solve1(final int[] A, final int[] B, final int[] C) {
        int len = A.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int cap = A[i];
            // int[][] dp = new int[len + 1][cap + 1];

            int[][] dp = new int[len][cap + 1];
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < cap + 1; k++) {
                    dp[j][k] = -1;
                }
            }

            int ans = knapsack(B, C, cap, len - 1, dp);
            sum += ans;
        }
        return sum;
    }

    public static int knapsack(int[] B, int[] C, int cap, int i, int[][] dp) {
        if (i < 0) {
            return 0;
        }
        if (cap < B[i]) {
            int x = knapsack(B, C, cap, i - 1, dp);
            dp[i][cap] = x;
            return x;
        }
        if (dp[i][cap] != -1) {
            return dp[i][cap];
        }
        int ans = knapsack(B, C, cap - B[i], i, dp) + C[i];
        ans = Math.max(ans, knapsack(B, C, cap, i - 1, dp));
        // int z = Math.min(x, y);
        dp[i][cap] = ans;
        return ans;
    }
}
