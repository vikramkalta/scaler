public class KnapsackUnlimitedItem {
    public static void main(String args[]) {
        int A = 10;
        int[] B= {6,7,8};
        int[]C={5,5,5};
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, int[] B, int[] C) {
        int len = B.length;
        int[][] dp = new int[len][A+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < A+1; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = knapsackUnbound(A, B, C, len-1, dp);
        return ans;
    }
    public static int knapsackUnbound(int A, int[] B, int[] C, int i, int[][] dp) {
        if (i < 0) {
            return 0;
        }
        if (C[i] > A) {
            return 0;
        }
        if (dp[i][A]!=-1){
            return dp[i][A];
        }
        int x = knapsackUnbound(A - C[i], B, C, i, dp) + B[i];
        int y = knapsackUnbound(A, B, C, i - 1, dp);
        int z = Math.max(x, y);
        dp[i][A] = z;
        return z;
    }
}
