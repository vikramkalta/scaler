import java.util.ArrayList;

public class GrayCode {
    public static void main(String args[]) {
        System.out.println(grayCode(3));
        // n=3
        // 000
        // 001
        // 011
        // 010
        // 110
        // 111
        // 101
        // 100
        // n=2
        // 00
        // 01
        // 11
        // 10
    }

    public static int[] grayCode(int A) {
        String[] result1 = solve(A);
        int x1 = 1 << A;
        int[] ans = new int[x1];
        for (int i = 0; i < result1.length; i++) {
            int currInt = Integer.parseInt(result1[i], 2);
            ans[i] = currInt;
        }
        return ans;
    }

    public static String[] solve(int len) {
        if (len == 0) {
            return new String[] {"0"};
        }
        if (len == 1) {
            return new String[] {"0", "1"};
        }
        if (len == 2) {
            return new String[] {"00","01","11","10"};
        }
        String[] x = solve(len - 1);
        String[] x1 = new String[x.length];
        String[] x2 = new String[x.length];
        for (int i = 0; i < x.length; i++) {
            x1[i] = "0" + x[i];
        }
        for (int i = 0; i < x.length; i++) {
            x2[i] = "1" + x[i];
        }
        int len2 = 2 * x.length;
        String[] finalX = new String[len2];
        for (int i = 0; i < x.length; i++) {
            finalX[i] = x1[i];
        }
        for (int i = x.length; i < len2; i++) {
            finalX[i] = x2[len2 - i - 1];
        }
        return finalX;
    }

    // public static void solve1(int len, ArrayList<int[]> result, int i) {
    //     if (i >= len) {
    //         int[] y = new int[len];
    //         for (int index = 0; index < len; index++) {
    //             y[index] = x[index];
    //         }
    //         result.add(y);
    //         return;
    //     }
    //     solve1(len, result, i + 1);
    //     x[i] = 1;
    //     solve1(len, result, i + 1);
    //     x[i] = 0;
    // }
}
