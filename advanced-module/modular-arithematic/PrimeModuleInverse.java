public class PrimeModuleInverse {
    public static void main(String args[]) {
        System.out.println(solve(7, 2));
        // System.out.println(solve(3, 5));
        // System.out.println(solve(6, 23));
        // System.out.println(solve(7696377, 4898783));
    }

    public static int solve(int A, int B) {
        long ans = powMod((long) A, (long) (B - 2), (long) B);
        return (int) ans;
    }

    private static long powMod(long a, long p, long m) {
        if (p == 1 || p == 0) {
            return a % m;
        }
        long x = powMod(a, p / 2, m);
        if (p % 2 == 0) {
            x = x % m;
            return (x * x) % m;
        } else {
            a = a % m;
            x = x % m;
            long _x = (a * x) % m;
            return (x * _x) % m;
        }
    }
}
