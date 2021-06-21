public class ReverseBits {
    public static void main(String args[]) {
        // System.out.println(solve(16));
        // System.out.println(solve(0));
        System.out.println(solve(3));
        // System.out.println(solve(2));
    }

    public static long solve(int A) {
        // StringBuilder bits = A%2==0?"0":"1";
        StringBuilder bits = new StringBuilder();
        while (A > 0) {
            if ((A & 1) == 1) {
                bits.append("1");
            } else {
                bits.append("0");
            }
            A >>= 1;
        }
        int len = bits.length();
        for (int i = len; i < 32; i++) {
            bits.append("0");
        }

        int i = 0;
        long ans = 0;
        while (i < 32) {
            long power = 32 - 1 - i;
            char curr = bits.charAt(i);
            if (curr == '1') {
                long x = 1l << power;
                ans += x;
            }
            i++;
        }

        return ans;
    }
}
