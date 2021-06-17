public class MaxModulo {
    public static void main(String args[]) {
        // System.out.println(solve(2, 1));
        // System.out.println(solve(10, 5));
        // System.out.println(solve(6816621, 8157697));
        System.out.println(solve(7696377, 4898783));
    }

    public static int solve(int A, int B) {
        int max = A;
        if (max < B) {
            max = B;
            return B - A;
        } else {
            return A - B;
        }
        // int ans = 1;
        // for (int i = max; i >= 1; i--) {
        // if (A % i == B % i) {
        // ans = i;
        // break;
        // }
        // }
        // return ans;
    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
