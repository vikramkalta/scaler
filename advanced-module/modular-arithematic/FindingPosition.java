public class FindingPosition {
    public static void main(String args[]) {
        // System.out.println(solve(10));
        System.out.println(solve(5));
    }

    public static int solve(int A) {
        int pow2 = 0;
        while (true) {
            A = A / 2;
            if (A <= 0) {
                break;
            }
            pow2++;
        }
        return 1 << pow2;
    }
}
