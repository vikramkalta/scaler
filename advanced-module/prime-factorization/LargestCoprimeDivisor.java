public class LargestCoprimeDivisor {
    public static void main(String args[]) {
        // System.out.println(solve(30, 12));
        // System.out.println(solve(2, 3));
        System.out.println(solve(5, 10));
        // System.out.println(solve(1000));
    }

    public static int solve(int A, int B) {
        int count = 1;
        // int n = A / count;
        int x = A;
        while (x >= 1) {
            x = A / count;
            if (A % count == 0) {
                if (gcd(x, B) == 1) {
                    return x;
                }
            }
            count++;
        }
        return x;
    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
