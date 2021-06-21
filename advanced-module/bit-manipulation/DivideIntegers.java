public class DivideIntegers {
    public static void main(String args[]) {
        // System.out.println(solve(5, 2));
        // System.out.println(solve(-1, 1));
        // System.out.println(solve(7, 1));
        // System.out.println(solve(-2147483648, -1));
        System.out.println(solve(2147483647, 1));
    }

    public static int solve(int A, int B) {
        if (B == -1 && A == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) A);
        long b = Math.abs((long) B);
        int result = 0;
        while (a >= b) {
            // calculate number of left shifts
            int numShift = 0;
            while (a >= (b << numShift)) {
                numShift++;
            }
            // dividend minus the largest shifted divisor
            result += 1 << (numShift - 1);
            a -= (b << (numShift - 1));
        }
        if (A > 0 && B > 0 || A < 0 && B < 0) {
            return result;
        } else {
            return -result;
        }
    }

    public static int solve1(int A, int B) {
        if (B == -1 && A == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int ans = 0;
        long a = (long) A;
        long b = (long) B;
        if (a >= 0) {
            while (a > 0) {
                a -= b;
                ans++;
            }
        } else {
            while (a < 0) {
                a += b;
                ans--;
            }
        }

        return ans;
    }

    public static int solve2(int A, int B) {
        int ans = 0;
        while (A > 0) {
            A -= B;
            ans++;
        }
        return ans;
    }
}
