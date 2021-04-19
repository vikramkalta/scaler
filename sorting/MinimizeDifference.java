import java.util.ArrayList;
import java.util.Collections;

public class MinimizeDifference {
    public static void main(String args[]) {
        // int[] arr = {2, 6, 3, 9, 8};
        int[] arr = { 1, 1, 7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(minimizeDiff(A, 3));
        System.out.println(minimizeDiff(A, 7));
    }

    public static int minimizeDiff(ArrayList<Integer> A, int B) {
        int len = A.size();

        Collections.sort(A);

        int max = A.get(A.size() - 1);
        int min = A.get(0);

        int ops = 0;

        int ltr = 0;
        int rtl = len - 1;

        while(true) {
            boolean isExhausted = false;
            for (int i = ltr; i < ltr + 1; i++) {
                int next = A.get(i + 1);

                if (min < next) {
                    min++;
                    A.set(i, min);
                    ops++;
                }

                if (min > next) {
                    min = next;
                }
                
                if (ops == B) {
                    isExhausted=  true;
                    break;
                }
            }
            if (isExhausted) {
                break;
            }
            ltr++;
            if (ltr >= len - 1) {
                ltr = 0;
            }
            for (int i = rtl; i >= rtl; i--) {
                int prev = A.get(i - 1);

                if (max > prev) {
                    max--;
                    A.set(i, max);
                    ops++;
                }

                if (max > prev) {
                    max = prev;
                }
                // ops++;
                if (ops == B) {
                    isExhausted = true;
                    break;
                }
            }
            if (isExhausted) {
                break;
            }
            rtl--;
            if (rtl <= 0) {
                rtl = len - 1;
            }
        }

        return A.get(A.size() - 1) - A.get(0);
    }
}
