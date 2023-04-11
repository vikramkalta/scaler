public class AnotherSequence {
    public static void main(String args[]) {
        int x = solve(3);
        System.out.println(x);
    }
    public static int solve(int A) {
        int x = fun(A);
        return x;
    }
    public static int fun(int A) {
        if (A == 0) {
            return 1;
        }
        if (A == 1) {
            return 1;
        }
        if (A == 2) {
            return 2;
        }
        int x = fun(A - 1);
        int y = fun(A - 2);
        int z = solve(A - 3);
        return x + y + z + A;
    }
}