import java.util.HashMap;

public class FlipArray {
    public static void main(String args[]) {
        // int[] A = {15,10,6};
        int[] A = { 1, 2, 3 };
        // int[] A = {5, 4, 6, 8, 7, 2, 3};
        // int[] A = { 5, 4, 6, 8, 7 };
        // int[] A = {3, 3, 7, 10, 2, 1, 5, 3, 8, 5, 1, 4, 3, 9, 1, 4, 8, 1, 1, 4, 5,
        // 10, 3, 8, 5, 3, 6, 3, 5, 5, 4, 9, 7, 1, 9, 10, 3, 3, 4, 2, 9, 4, 5, 3, 3, 5,
        // 6, 2, 8, 6, 8, 2, 7, 10, 9, 2, 4, 4, 4, 8, 10, 9, 7, 8, 1, 5, 9, 5, 9, 2, 7,
        // 9, 6, 3, 2, 10, 10, 7, 1, 7, 5, 10, 10, 1, 9, 10, 4, 2, 5, 9, 10};
        System.out.println(solve(A));
    }

    public static int solve(final int[] A) {
        int sum = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        int C = sum / 2;
        int[][] dp = new int[len][sum];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < sum; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;
        dp[0][A[0]] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= C; j++) {
                if (A[i] <= j) {
                    int val1 = dp[i - 1][j];
                    int val2 = dp[i - 1][j - A[i]];
                    int ans = Integer.MAX_VALUE;
                    if (val1 != -1)
                        ans = Math.min(ans, val1);
                    if (val2 != -1)
                        ans = Math.min(ans, val2 + 1);

                    if (ans != Integer.MAX_VALUE) {
                        dp[i][j] = ans;
                    } else {
                        dp[i][j] = -1;
                    }
                } else {
                    int val = dp[i - 1][j];
                    if (val != -1)
                        dp[i][j] = val;
                }
            }
        }
        for (int i = C; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if(dp[j][i]!=-1){
                    ans=Math.min(ans,dp[j][i]);
                }
            }
            if(ans!=Integer.MAX_VALUE)return ans;
        }
        return -1;
    }

    public static int knapsack(int[] A, int i, int w, int[][] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        if (A[i] > w) {
            int x = knapsack(A, i - 1, w, dp);
            dp[i][w] = x;
            return x;
        }
        int x = knapsack(A, i - 1, w, dp);
        int y = knapsack(A, i - 1, w - A[i], dp) + 1;
        int z = Math.max(x, y);
        dp[i][w] = z;
        return z;
    }
}