import java.util.ArrayList;

public class MinimumSquaresSum {
    public static void main(String args[]) {
        // System.out.println(solve(100000));
        System.out.println(solve(97280));
        // System.out.println(getMinSquares(97280));
        // System.out.println(getMinSquares(113));
        // System.out.println(solve(10));
        // System.out.println(solve(113));
        // System.out.println(solve(13));
    }

    public static int solve(int A) {
        if (A <= 3) {
            return A;
        }
        
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            if (i < 4) {
                dp.add(i);
            }else{
                dp.add(Integer.MAX_VALUE);
            }
        }
        // int closestSqrt = (int)Math.sqrt(A);
        for (int i = 4; i <= A; i++) {
            int sqrt = (int)Math.sqrt(i);

            for (int j = 1; j <= sqrt; j++) {
                int sqr = j * j;
                int x = dp.get(i - sqr);
                int y = x + 1;
                dp.set(i, Math.min(dp.get(i), y));
            }
        }

        return dp.get(A);
    }

    public static int solve2(int A) {
        if (A <= 3) {
            return A;
        }
        int min = Integer.MAX_VALUE;
        int closestSqrt = (int) Math.sqrt(A);
        int ans = getMinSquaresSum(A, closestSqrt, min);
        return ans;
    }

    public static int getMinSquaresSum(int A, int closestSqrt, int min) {
        int count = 0;
        for (int i = 1; i <= closestSqrt; i++) {
            int a = A;
            int c = i;
            count = 0;

            while (a > 0) {
                int x = c * c;
                a = A - x;
            }
        }
        return min;
    }

    public static int getMinSquaresSumGreedy(int A, int closestSqrt, int min) {
        int count = 0;
        for (int i = closestSqrt; i >= 1; i--) {
            int a = A;
            int c = i;
            count = 0;
            while (a > 0) {
                int x = c * c;
                a = a - x;
                c = (int) Math.sqrt(a);
                count++;
                if (count > min) {
                    break;
                }
            }
            if (min > count) {
                min = count;
            }
        }
        return min;
    }

    public static int getMinSquaresSum1(int A, int closestSqrt, int min) {
        if (closestSqrt == 0) {
            return min;
        }
        int count = 0;
        int a = A;

        int c = closestSqrt;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (a > 0) {
            // numbers.add(c);
            int square = c * c;
            a = a - square;
            // if (a == 0) {
            // System.out.println("arr: " + numbers);
            // }
            c = (int) (Math.sqrt(a));
            count++;
            if (count > min) {
                break;
            }
        }
        // numbers.clear();
        // System.out.println("count: " + count);
        if (count < min) {
            min = count;
        }
        return getMinSquaresSum(A, closestSqrt - 1, min);
    }

    public static int solve1(int A) {
        int a = A;
        int count = 0;
        while (a > 0) {
            double x = Math.sqrt(a);
            int y = (int) x;
            int z = y * y;
            a = a - z;
            count++;
        }
        return count;
    }

    static int getMinSquares(int n) {

        // We need to add a check
        // here for n. If user enters
        // 0 or 1 or 2
        // the below array creation
        // will go OutOfBounds.
        if (n <= 3)
            return n;

        // Create a dynamic programming
        // table
        // to store sq
        int dp[] = new int[n + 1];

        // getMinSquares table for
        // base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // getMinSquares rest of the
        // table using recursive
        // formula
        for (int i = 4; i <= n; i++) {

            // max value is i as i can
            // always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;

            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 1; x <= Math.ceil(Math.sqrt(i)); x++) {
                int temp = x * x;
                if (temp > i)
                    break;
                else {
                    int y = dp[i];
                    int z = dp[i - temp];
                    if (dp[i] == 4) {
                        System.out.println("dp: " + dp[i]);
                        break;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
                }

            }
        }

        // Store result and free dp[]
        int res = dp[n];

        return res;
    }
}
