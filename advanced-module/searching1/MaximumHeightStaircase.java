public class MaximumHeightStaircase {
    public static void main(String args[]) {
        // System.out.println(solve(50));
        System.out.println(solve(10));
        System.out.println(solve(20));
    }

    public static int solve(int A) {
        int ans = 1;
        int i = 1;
        while (ans < A) {
            i++;
            ans += i;
        }
        return ans == A ? i : i - 1;
    }
}
