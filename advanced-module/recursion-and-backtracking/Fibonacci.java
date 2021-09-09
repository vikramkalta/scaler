public class Fibonacci {
    public static void main(String args[]) {
        // 1,1,2,3,5,8
        System.out.println(solve(5));
    }

    public static int solve(int A) {
        int n = fib(A);
        return n;
    }

    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        int x = fib(n - 1);
        int y = fib(n - 2);
        int z = x + y;
        return z;
    }
}
