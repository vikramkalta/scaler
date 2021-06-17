public class VeryLargePower {
    public static void main(String args[]) {
        // System.out.println(solve(1, 1));
        // System.out.println(solve(2, 2));
        // System.out.println(solve(2, 3));
        // System.out.println(solve(13, 23));
        System.out.println(solve(2, 27));
    }

    public static int solve(int A, int B) {
        int mod = 1000000007;
        int b = 1;
        for (int i = 1; i <= B; i++) {
            b *= i;
        }
        long ans = powMod((long) A, (long) b, (long) mod);
        return (int) ans % mod;
        // return (int) ans;
    }

    private static long powMod(long a, long p, long m) {
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return a % m;
        }
        long x = powMod(a, p / 2, m);
        x = x % m;
        if (x < 0)
            x += m;
        if (p % 2 == 0) {
            return (x * x) % m;
        } else {
            a = a % m;
            if (a < 0)
                a += m;
            long z = (a * x) % m;
            if (z < 0)
                z += m;
            z = (z * x) % m;
            if (z < 0)
                z += m;
            return z;
            // return (a * x * x) % m;
        }
    }

    private static int getExponent(int A, int B) {
        int ans = A;
        int count = 2;
        while (true) {
            ans = ans * A;
            if (count >= B) {
                break;
            }
            count++;
        }
        return ans;
    }
}
