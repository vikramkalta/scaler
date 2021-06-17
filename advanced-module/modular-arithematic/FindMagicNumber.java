public class FindMagicNumber {
    public static void main(String args[]) {
        // System.out.println(solve(3));
        // System.out.println(solve(30));
        for (int i = 1; i <= 32; i++) {
            if (i == 24) {
                System.out.println();
            }
            System.out.println(solve(i));
        }
    }

    public static int solve(int A) {
        int pow = 0;
        int _a = A;
        while (_a > 1) {
            _a = _a / 2;
            pow++;
        }
        int powOf2 = 1 << pow;
        int remaining = A - powOf2;
        int _remaining = remaining;

        int remainingPow = 0;
        int acc = 0;
        while (_remaining > 1) {
            _remaining = _remaining / 2;
            remainingPow++;
            if (_remaining == 1) {
                int x = 1 << remainingPow;
                if (remaining - x == 0) {
                    remaining = remainingPow + 1;
                }
                if (remaining - x > 0) {
                    remaining = remaining - x;
                    _remaining = remaining;
                    acc += (int) Math.pow(5, remainingPow + 1);
                    remainingPow = 0;
                }
            }
        }

        if (remaining > 0) {
            acc += (int) Math.pow(5, remaining);
        }

        int ans = (int) Math.pow(5, pow + 1);
        ans += acc;
        return ans;
    }

    public static int solve1(int A) {
        int pow = 0;
        pow = (A / 2) + 1;
        int ans = 1;
        for (int i = 1; i <= pow; i++) {
            ans *= 5;
        }
        if (A % 2 != 0) {
            // add 5
            ans += 5;
        }
        return ans;
    }
}
