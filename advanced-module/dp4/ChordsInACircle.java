public class ChordsInACircle {
    public static void main(String args[]) {
        // int A = 1;
        // int A = 2;
        // int A = 3;
        int A = 4;
        System.out.println(chordCnt(A));
    }

    public static int chordCnt(int A) {
        if (A <= 2) {
            return A;
        }
        long mod = 1000000007l;
        long[] dp = new long[A+1];
        dp[0] = 1l;
        dp[1] = 1l;
        dp[2] = 2l;
        for (int i = 2; i <= A; i++) {
            long sum = 0l;
            int start = 0;
            int end = i - 1;
            while (start < i && end >= 0) {
                long x = dp[start] * dp[end];
                sum += x;
                sum = sum % mod;
                start++;
                end--;
            }
            dp[i] = sum;
        }
        return (int)dp[A];
    }
}