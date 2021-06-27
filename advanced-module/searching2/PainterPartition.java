import java.util.ArrayList;

public class PainterPartition {
    public static void main(String args[]) {
        // int[] arr = { 3, 6, 9, 4 };
        // int[] arr = { 185, 186, 938, 558, 655, 461, 441, 234, 902, 681 };
        // int[] arr = { 884, 228, 442, 889 };
        // int[] arr = { 452, 305, 314, 443, 826, 163, 433, 51, 372 };
        int[] arr = { 1000000, 1000000 };
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            C.add(arr[i]);
        // System.out.println(solve(3, 5, C));
        // System.out.println(solve(3, 10, C));
        // System.out.println(solve(4, 10, C));
        // System.out.println(solve(7, 10, C));
        System.out.println(solve(1, 1000000, C));
    }

    public static int solve(int A, int B, ArrayList<Integer> C) {
        int mod = 10000003;
        int len = C.size();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curr = C.get(i);
            if (max < curr) {
                max = curr;
            }
            sum += curr;
        }
        if (len <= A) {
            long ans = 1l * (max * B);
            ans = ans % mod;
            if (ans < 0)
                ans += mod;
            return (int) ans;
        }
        if (A == 1) {
            // long ans = (long) sum * (long) B;
            long ans = 1l * sum * B;
            ans = ans % mod;
            if (ans < 0)
                ans += mod;
            return (int) ans;
        }

        int l = max, r = sum, m = (l + r) / 2;
        int min = Integer.MAX_VALUE;
        // another answer can be sum/painters.
        while (l <= r) {
            m = (l + r) / 2;
            int minimumEffort = 0;
            int count = 1;
            for (int i = 0; i < len; i++) {
                int curr = C.get(i);
                minimumEffort += curr;
                if (minimumEffort > m) {
                    minimumEffort = curr;
                    count++;
                }
            }
            // System.out.println("count " + count);
            if (count <= A) {
                r = m - 1;
                if (A == count && min > m) {
                    min = m;
                }
            } else if (count > A) {
                l = m + 1;
            } else if (m < max) {
                break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = max;
        }
        long ans = 1l * min * B;
        ans = ans % mod;
        if (ans < 0)
            ans += mod;
        return (int) ans;
    }
}