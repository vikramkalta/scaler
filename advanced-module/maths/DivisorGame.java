public class DivisorGame {
    public static void main(String args[]) {
        // System.out.println(divisorGame(6,1,4));
        // System.out.println(divisorGame(12,3,2));
        System.out.println(divisorGame(81991, 2549, 7));
    }

    public static int divisorGame(int A, int B, int C) {
        if (A % B != 0 && A % C != 0) {
            return 0;
        }
        long x = lcm(B, C);
        long ans = (long) (A / x);
        return (int) ans;
    }

    private static long lcm(int A, int B) {
        long x = (long) (A * B);
        long g = gcd((long)A, (long)B);
        long y = (long) (x / g);
        return y;
    }

    private static long gcd(long A, long B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public static int divisorGameBrute(int A, int B, int C) {
        if (A % B != 0 && A % C != 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < A; i++) {
            if (i % B == 0 && i % C == 0) {
                count++;
            }
        }
        return count;
    }
}
