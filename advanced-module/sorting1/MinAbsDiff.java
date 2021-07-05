import java.util.ArrayList;
import java.util.Collections;

public class MinAbsDiff {
    public static void main(String args[]) {
        int[] arr = { 3, 2, 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        int prev = A.get(0);
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            int diff = curr - prev;
            if (min > diff) {
                min = diff;
            }
            prev = curr;
        }
        return min;
    }
}
