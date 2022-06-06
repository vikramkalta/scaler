public class NDigitNumbers {
    public static void main(String args[]) {
        // int A = 2;
        // int B = 4;
        // int A = 1;
        // int B = 3;
        int A = 75;
        int B = 22;
        System.out.println(solve(A, B));
    }

    public static long mod = 1000000007l;

    public static int solve(int A, int B) {
        long[][] dp = new long[A][B + 1];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B + 1; j++) {
                dp[i][j] = -1;
            }
        }
        long ans = nDigitNums(A - 1, B, 1, dp);
        return (int) ans;
    }

    public static long nDigitNums(int pos, int sum, int s, long[][] dp) {
        if (sum < 0) {
            return 0;
        }
        if (pos == 0) {
            if (sum <= 9 && sum >= 0) {
                return 1l;
            } else {
                return 0l;
            }
        }
        if (dp[pos][sum] != -1) {
            return dp[pos][sum];
        }
        long ans = 0l;
        for (int i = s; i <= 9; i++) {
            ans = (ans + nDigitNums(pos - 1, sum - i, 0, dp)) % mod;
        }
        dp[pos][sum] = ans;
        return ans;
    }
}