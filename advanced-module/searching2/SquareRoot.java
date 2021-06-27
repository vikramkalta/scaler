public class SquareRoot {
    public static void main(String args[]) {
        // System.out.println(solve(17));
        // System.out.println(solve(1));
        // System.out.println(solve(2));
        // System.out.println(solve(6));
        // System.out.println(solve(3));
        // System.out.println(solve(4));
        // System.out.println(solve(8));
        System.out.println(solve(930675566));
    }

    public static int solve(int A) {
        if (A == 0) {
            return 0;
        }
        if (A == 1 || A == 2 || A == 3) {
            return 1;
        }
        long l = 2, r = A / 2, m = (l + r) / 2;
        while (l <= r) {
            // m = (l + r) / 2;
            long x = m * m;
            if (x + m > A && x - m < A) {
                if (x > A) {
                    m--;
                }
                break;
            }
            if (x > A) {
                r = m - 1;
            } else if (x < A) {
                l = m + 1;
            } else {
                break;
            }
            m = (l + r) / 2;
        }
        return (int) m;
    }
}
