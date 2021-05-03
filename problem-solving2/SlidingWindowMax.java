import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMax {
    public static void main(String args[]) {
        // int[] arr = {1, 3, -1, -3, 5, 3, 6, 7}; // 3,3,5,5,6,7
        // int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951,
                867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574,
                516, 36, 705, 900, 482, 558, 937, 207, 368 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(slidingWindowMax(A, 3));
        // System.out.println(slidingWindowMax(A, 2));
        // System.out.println(slidingWindowMax(A, 1));
        System.out.println(slidingWindowMax(A, 9));
    }

    public static ArrayList<Integer> slidingWindowMax(List<Integer> A, int B) {
        if (B == 1) {
            return new ArrayList<>(A);
        }
        int len = A.size();

        ArrayList<Integer> result = new ArrayList<>();

        int max = 0;
        ArrayList<Integer> slidingWindow = new ArrayList<>();
        for (int i = 0; i < len; i++) {

            int curr = A.get(i);
            if (curr > max) {
                max = curr;
            }
            if (i == B - 1) {
                result.add(max);
            }

            if (i > B - 1) {
                if (curr <= max) {
                    if (slidingWindow.get(0) != max) {
                        slidingWindow.remove(0);
                        slidingWindow.add(curr);
                        result.add(max);
                    } else {
                        if (slidingWindow.size() == B) {
                            slidingWindow.remove(0);
                            slidingWindow.add(curr);
                            max = Integer.MIN_VALUE;
                            for (int j = 0; j < slidingWindow.size(); j++) {
                                int swCurr = slidingWindow.get(j);
                                if (max < swCurr) {
                                    max = swCurr;
                                }
                            }
                            result.add(max);
                        }
                    }
                    
                } else {
                    max = curr;
                    slidingWindow.remove(0);
                    slidingWindow.add(curr);
                    result.add(max);
                }
            } else {
                slidingWindow.add(curr);
            }
        }
        return result;
    }
}
// if (curr < max) {
// if (clearCount != 0) {
// clearCount--;
// } else {
// slidingWindow.remove(0);
// }
// // if (slidingWindow.get(0) == max) {
// // }
// // slidingWindow.remove(0);
// max = Integer.MIN_VALUE;
// for (int j = 0; j < slidingWindow.size(); j++) {
// int swCurr = slidingWindow.get(j);
// if (swCurr > max) {
// max = swCurr;
// }
// }
// result.add(max);
// slidingWindow.add(curr);
// } else {
// // remove all elements from slidingWindow
// clearCount = slidingWindow.size();
// slidingWindow.clear();
// slidingWindow.add(curr);
// result.add(curr);
// }
// BRUTE

// if (i + 1 >= B) {
// result.add(max);
// }
// for (int j = i; j < B+i; j++) {
// int curr = A.get(j);
// if (curr > max) {
// max = curr;
// }
// }
// result.add(max);
