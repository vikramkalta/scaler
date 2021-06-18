public class MaximumIntersections {
    public static void main(String args[]) {
        // System.out.println(solve(2, 2));
        System.out.println(solve(1000, 1000));
    }

    public static int solve(int A, int B) {
        long countCircleIntersections = npr(B, B - 2);
        long countLineIntersections = ncr(A);
        long countCircleLineIntersections = 2 * A * B;
        long ans = countCircleIntersections + countLineIntersections + countCircleLineIntersections;
        return (int) ans;
    }

    public static long npr(long A, long B) {
        long ans = 1l;
        for (long i = A; i > B; i--) {
            ans *= i;
        }
        return ans;
    }

    private static long ncr(long n) {
        long x = n - 1;
        x = x * n;
        return x / 2;
    }
}
