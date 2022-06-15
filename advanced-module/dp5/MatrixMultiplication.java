public class MatrixMultiplication {
    public static void main(String args[]) {
        int[] A = {40, 20, 30, 10, 30};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int len = A.length;
        int[][] dp = new int[len-1][len-1];

        for (int g = 0; g < len-1; g++) {
            for (int i = 0, j = g; j < len-1; i++,j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = A[i] * A[j] * A[j+1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int lc = dp[i][k];
                        int rc = dp[k+1][j];
                        int mc = A[i] * A[k+1] * A[j+1];
                        int tc = lc+rc+mc;
                        if (min > tc) {
                            min = tc;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][len-2];
    }
}