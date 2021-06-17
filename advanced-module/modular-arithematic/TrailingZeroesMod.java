public class TrailingZeroesMod {
    public static void main(String args[]) {
        // System.out.println(solve(7));
        System.out.println(solve(9247));

    }

    public static int solve(int A) {
        int count = 0;
        int mul = 5;
        int x = 5;
        while (true) {
            int div = A / x;
            count = count + div;
            x = x * mul;
            if (div <= 0) {
                break;
            }
        }
        return count;
    }
}
