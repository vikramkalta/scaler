import java.math.BigInteger;

public class EnumeratingGCD {
    public static void main(String args[]) {
        // System.out.println(solve("123", "234"));
        System.out.println(solve("678728391838182039102", "678728391838182039103"));
    }
    // 10^100
    // 10000000000000000000000000000000000
    // 81726265155289999995555555000000665
    public static String solve(String A, String B) {
        if (A.equals(B)) {
            return A;
        } else {
            return "1";
        }
    }

    public static String solve1(String A, String B) {
        BigInteger a = new BigInteger(A);
        BigInteger b = new BigInteger(B);
        BigInteger ans = gcd(a, b);
        String x = ans.toString();
        return x;
    }

    private static BigInteger gcd(BigInteger A, BigInteger B) {
        BigInteger zero = new BigInteger("0");
        if (B.equals(zero)) {
            return A;
        }
        BigInteger mod = A.mod(B);
        return gcd(B, mod);
    }
}
