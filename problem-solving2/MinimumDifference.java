import java.util.ArrayList;
import java.util.Collections;

public class MinimumDifference {
    public static void main(String args[]) {
        // int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {37, 19, 71, 72, 5, 4, 74, 2, 30, 33, 85, 1, 7, 14, 98, 27, 51, 7, 24, 88, 86, 81, 77, 64, 13, 3, 63, 75, 29, 50, 90, 3, 22, 94, 40, 72, 75, 26, 32, 64, 62, 59, 19, 16};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(minAbsoluteDifference(A));
    }

    public static int minAbsoluteDifference(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int curr = A.get(i);
            int next = A.get(i+1);
            if (next - curr == 0) {
                minDiff = 0;
                break;
            } else {
                int diff = next - curr;
                if (minDiff > diff) {
                    minDiff = diff;
                }
            }
        }
        return minDiff;

        // int minIndex = 0;
        // for (int i = 0; i < len; i++) {
        //     int curr = A.get(i);
        //     for (int j = i + 1; j < len; j++) {
        //         int currJ = A.get(j);
        //         int diff = 0;
        //         if (currJ > curr) {
        //             diff = currJ - curr;
        //         } else {
        //             diff = curr - currJ;
        //         }
        //         if (minDiff > diff) {
        //             minDiff = diff;
        //         }
        //     }
        // }
        // return minDiff;
    }
}
