public class WaysToFormMaxHeaps {
    public static void main(String args[]) {
        System.out.println(solve(4));
        System.out.println(solve(10));
    }

    public static long mod = 1000000007l;

    public static int solve(int A) {
        long[][] combs = getCombs(A);
        getCombs(A);
        return (int) (helper(A, combs) % mod);
    }

    private static long helper(int A, long[][] combs) {
        if (A <= 1) {
            return 1;
        }
        int n = A;
        int h = 0;
        while (A > 1) {
            h++;
            A /= 2;
        }
        int m = (int) Math.pow(2, h);
        int p = n - (m - 1);
        // L = 2h - 1 if p >= m/2;
        // = 2h - 1 - (m/2 - p) if p<(m/2)
        int L = 0;
        if (p >= m / 2) {
            L = m - 1;
        } else {
            L = m - 1 - (m / 2 - p);
        }
        long x = combs[n-1][L];
        long y = helper(L, combs) % mod;
        long z = helper(n - 1 - L, combs) % mod;
        return x * y * z;
    }

    private static long[][] getCombs(int A) {
        long[][] combs = new long[A + 1][A + 1];
        for (int i = 1; i <= A; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    combs[i][j] = 1l;
                } else {
                    combs[i][j] = (combs[i - 1][j] + combs[i - 1][j - 1] % mod);
                }
            }
        }
        return combs;
    }
}