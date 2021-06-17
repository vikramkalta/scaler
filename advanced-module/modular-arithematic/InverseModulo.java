public class InverseModulo {
    public static void main(String args[]) {
        // System.out.println(solve(5, 2, 13));
        // System.out.println(solve(6, 2, 13));
        System.out.println(solve(26, 18, 367));
    }

    public static int solve(int A, int B, int C) {
        long x = A - B;
        long fact = fact(A, x, C);
        long inverseFact = fact(B, 1, C);
        long inverse = fermat(inverseFact, C - 2, C);
        long ans = (fact * inverse) % C;
        if (ans < 0)
            ans += C;
        return (int) ans;
    }

    private static long fact(long a, long b, long p) {
        long ans = 1;
        for (long i = a; i > b; i--) {
            ans = (ans * i) % p;
        }
        return ans;
    }

    public static long fermat(long a, long p, long m) {
        if (p == 0 || p == 1) {
            return a;
        }
        long x = fermat(a, p / 2, m);
        x = x % m;
        if (p % 2 == 0) {
            return (x * x) % m;
        } else {
            a = a % m;
            long _x = a * x;
            _x = _x % m;
            return (_x * x) % m;
        }
    }
}
