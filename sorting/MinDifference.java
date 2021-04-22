import java.util.ArrayList;
import java.util.Collections;

public class MinDifference {
    public static void main(String args[]) {
        // int[] arr = {2, 6, 3, 9, 8};
        // int[] arr = {5, 1, 7};
        int[] arr = {9, 1, 2, 5, 9, 4};
        // int[] arr = { 1, 1, 7 };
        // int[] arr = {4, 1};
        // int[] arr = {2, 8, 3, 7, 8, 7, 9};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(minimizeDiff(A, 3));
        // System.out.println(minimizeDiff(A, 5));
        // System.out.println(minimizeDiff(A, 7));
        System.out.println(minimizeDiff(A, 7));
        // System.out.println(minimizeDiff(A, 6));
        // System.out.println(minimizeDiff(A, 9));
    }

    public static int minimizeDiff(ArrayList<Integer> A, int B) {
        int len = A.size();

        Collections.sort(A);

        int min = A.get(0);
        int max = A.get(A.size()-1);

        int diff = max - min;
        if (diff <= B) {
            return 0;
        }
        int avg = (max+min)/2;

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr > avg) {
                curr = curr - B;
                A.set(i, curr);
            } else {
                curr = curr + B;
                A.set(i, curr);
            }
        }
        Collections.sort(A);
        return A.get(A.size()-1)-A.get(0);
    }

    // public static int minimizeDiff(ArrayList<Integer> A, int B) {
    //     int len = A.size();

    //     Collections.sort(A);

    //     int min = A.get(0);
    //     int max = A.get(A.size()-1);

    //     int diff = max - min;
    //     if (diff == 0) {
    //         return 0;
    //     }

    //     int ops = 0;
    //     int mid = len / 2;

    //     // int i = 0;
    //     // int j = len - 1;
    //     boolean isExhausted = false;
    //     while (ops < B) {

    //         int i = 0;
    //         while (i < len) {
    //             int curr = A.get(i);
    //             int next = A.get(i + 1);

    //             if (curr == next) {
    //                 i++;
    //                 continue;
    //             } else {
    //                 curr++;
    //                 if (curr <= max) {
    //                     A.set(i, curr);
    //                 }
    //             }
    //             ops++;
    //             if (ops == B) {
    //                 isExhausted = true;
    //             }
    //             break;
    //         }
    //         if (isExhausted) {
    //             break;
    //         }

    //         // int j = len - 1;
    //         // while (j >= mid + 1) {
    //         //     int curr = A.get(j);
    //         //     int prev = A.get(j - 1);

    //         //     if (curr == prev && j - 1 >= mid + 1) {
    //         //         j--;
    //         //         continue;
    //         //     } else {
    //         //         curr--;
    //         //         if (curr >= min) {
    //         //             A.set(j, curr);
    //         //         }
    //         //     }
    //         //     ops++;
    //         //     if (ops == B) {
    //         //         isExhausted = true;
    //         //     }
    //         //     break;
    //         // }
    //         // if (isExhausted) {
    //         //     break;
    //         // }
    //     }
    //     return A.get(A.size()-1)-A.get(0);
    // }





    // public static int minimizeDiff(ArrayList<Integer> A, int B) {
    //     int len = A.size();

    //     Collections.sort(A);

    //     int min = A.get(0);
    //     int max = A.get(A.size()-1);

    //     int diff = max - min;
    //     if (diff == 0) {
    //         return 0;
    //     }

    //     int ops = 0;
    //     int mid = len / 2;

    //     // int i = 0;
    //     // int j = len - 1;
    //     boolean isExhausted = false;
    //     while (ops < B) {

    //         int i = 0;
    //         while (i < mid) {
    //             int curr = A.get(i);
    //             int next = A.get(i + 1);

    //             if (curr == next && len > 2) {
    //                 i++;
    //                 continue;
    //             } else {
    //                 curr++;
    //                 if (curr <= max) {
    //                     A.set(i, curr);
    //                 }
    //             }
    //             ops++;
    //             if (ops == B) {
    //                 isExhausted = true;
    //             }
    //             break;
    //         }
    //         if (isExhausted) {
    //             break;
    //         }

    //         int j = len - 1;
    //         while (j >= mid + 1) {
    //             int curr = A.get(j);
    //             int prev = A.get(j - 1);

    //             if (curr == prev && j - 1 >= mid + 1) {
    //                 j--;
    //                 continue;
    //             } else {
    //                 curr--;
    //                 if (curr >= min) {
    //                     A.set(j, curr);
    //                 }
    //             }
    //             ops++;
    //             if (ops == B) {
    //                 isExhausted = true;
    //             }
    //             break;
    //         }
    //         if (isExhausted) {
    //             break;
    //         }
    //     }
    //     return A.get(A.size()-1)-A.get(0);
    // }
}
