public class TrailingZeroesCombinatorics {
    public static void main(String args[]) {
        System.out.println(solve(25));
    }

    public static int solve(int A) {
        int mul = 5;
        int ans = 0;
        int x = mul;
        while (true) {
            int div = A / x;
            if (div < 1) {
                break;
            }
            ans += div;
            x = x * mul;
        }
        return ans;
    }
}
