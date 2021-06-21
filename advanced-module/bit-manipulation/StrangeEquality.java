public class StrangeEquality {
    public static void main(String args[]) {
        // System.out.println(solve(5));
        // System.out.println(solve(3));
        // System.out.println(solve(10));
        // System.out.println(solve(99));
        System.out.println(solve(3999));
    }

    public static int solve(int A) {
        int x = 0;
        for (int i = A - 1; i > 0; i--) {
            int sumXA = i + A;
            int sumXXor = i ^ A;
            if (sumXA == sumXXor) {
                x = i;
                break;
            }
        }
        int y = 0;
        for (int i = A + 1; i < Integer.MAX_VALUE; i++) {
            int sumYA = i + A;
            int sumYXor = i ^ A;
            if (sumYA == sumYXor) {
                y = i;
                break;
            }
        }
        return x ^ y;
    }
}
