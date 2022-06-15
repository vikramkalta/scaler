public class BuyingCandies {
    public static void main(String args[]) {
        int[] A = {1, 2, 3};
        int[] B = {2, 2, 10};
        int[] C = {2, 3, 9};
        int D = 8;
        System.out.println(solve(A, B, C, D));
    }

    public static int solve(int[] A, int[] B, int[] C, int D) {
        int len = A.length;
        int[][] dp = new int[len][D+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < D+1; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = maxHappiness(A, B, C, D, len - 1, dp);
        return ans;
    }
    public static int maxHappiness(int[] A, int[] B, int[] C, int D, int i, int[][] dp) {
        if (i < 0) {
            return 0;
        }
        if (D < C[i]) {
            int x = maxHappiness(A, B, C, D, i - 1, dp);
            dp[i][D] = x;
            return x;
        }
        if (dp[i][D]!=-1) {
            return dp[i][D];
        }
        int x = maxHappiness(A, B, C, D - C[i], i, dp) + (A[i] * B[i]);
        int y = maxHappiness(A, B, C, D, i - 1, dp);
        int z = Math.max(x, y);
        dp[i][D] = z;
        return z;
    }
}



// for (int i = 0; i < len + 1; i++) {
//     dp[i][0] = 0;
// }
// for (int i = 0; i < D+1; i++) {
//     dp[0][i] = 0;
// }

// for (int i = 1; i < len+1; i++) {
//     for (int j = 1; j < D+1; j++) {
//         if (D > C[i - 1]) {
//             dp[i][j] = dp[i-1][j];
//         } else {
//             int x = dp[i-1][j - C[i - 1]];
//             int y = dp[i-1][j];
//             dp[i][j] = Math.max(x, y);
//         }
//     }
// }