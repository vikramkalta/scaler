import java.util.ArrayList;
import java.util.Collections;

public class AggressiveCows {
    public static void main(String args[]) {
        int[] arr = { 2, 4, 6, 8, 10 };
        // int[] arr = { 1, 2, 3, 4, 5 };
        // int[] arr = { 1, 2 };
        // int[] arr = { 82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66,
        // 19, 5, 96, 84, 95 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A, 3));
        // System.out.println(solve(A, 3));
        // System.out.println(solve(A, 2));
        // System.out.println(solve(A, 8));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        Collections.sort(A);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (min > curr) {
                min = curr;
            }
            if (max < curr) {
                max = curr;
            }
        }
        int ansSpace = (max - min) / (B - 1);

        int l = 1, r = ansSpace, m = (l + r) / 2;
        // 2,4,6,8,10 - 3
        // 10-2/2 = 4
        // l=1,r=4,m=2
        while (l <= r) {
            int prev = A.get(0);
            int cowsAccommodated = 1;
            for (int i = 1; i < len; i++) {
                int curr = A.get(i);
                int diffAbs = Math.abs(curr - prev);
                if (diffAbs >= m) {
                    cowsAccommodated++;
                    prev = curr;
                }
            }
            if (cowsAccommodated >= B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            m = (l + r) / 2;
        }
        return m;
    }
}
