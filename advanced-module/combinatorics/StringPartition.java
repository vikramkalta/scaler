public class StringPartition {
    public static void main(String args[]) {
        // System.out.println(solve(4, 0, 1, 0));
        System.out.println(solve(4, 3, 1, 0));
    }

    public static int solve(int A, int B, int C, int D) {
        long x = ncr(A, B);
        long y = ncr(A, C);
        long z = ncr(A, D);
        long ans = x + y + z;
        return (int) ans;
    }

    private static long ncr(long n, long r) {
        long x = n - r;
        long y = fact(n, x);
        long z = fact(r, 1);
        return y / z;
    }

    private static long fact(long n, long r) {
        long ans = 1l;
        for (long i = n; i > r; i--) {
            ans *= i;
        }
        return ans;
    }
}
