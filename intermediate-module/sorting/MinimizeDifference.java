import java.util.ArrayList;
import java.util.HashMap;

public class MinimizeDifference {
    public static void main(String args[]) {
        // int[] arr = {2, 6, 3, 9, 8};
        // int[] arr = { 2, 8, 3, 7, 8, 7, 9 };
        // int[] arr = { 1, 1, 7 };
        // int[] arr = {4, 1};
        // int[] arr = { 9, 1, 2, 5, 9, 4 };
        int[] arr = {9, 6, 2, 4, 1, 2, 3, 3};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(minimizeDiff(A, 3));
        // System.out.println(minimizeDiff(A, 9));
        // System.out.println(minimizeDiff(A, 7));
        // System.out.println(minimizeDiff(A, 6));
        // System.out.println(minimizeDiff(A, 7));
        System.out.println(minimizeDiff(A, 10));
    }

    public static int minimizeDiff(ArrayList<Integer> A, int B) {
        int len = A.size();

        HashMap<Integer, Integer> hm = new HashMap<>();

        int max = A.get(0);
        int min = A.get(0);
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            if (max < curr) {
                max = curr;
            }
            if (min > curr) {
                min = curr;
            }

            boolean contains = hm.containsKey(curr);
            if (contains) {
                int val = hm.get(curr);
                val++;
                hm.replace(curr, val);
            } else {
                hm.put(curr, 1);
            }
        }

        while (B > 0) {
            if (max - min == 0) {
                break;
            }

            int minCount = hm.get(min);
            int maxCount = hm.get(max);

            if (B < minCount && B < maxCount) {
                break;
            }

            if (maxCount >= minCount) {
                // if (B >= minCount) {
                B = B - minCount;
                hm.remove(min);
                min++;

                boolean contains = hm.containsKey(min);
                if (contains) {
                    int val = hm.get(min);
                    val = val + minCount;
                    hm.replace(min, val);
                } else {
                    hm.put(min, minCount);
                }
            }

            if (minCount > maxCount) {
                // if (B >= maxCount) {
                B = B - maxCount;
                hm.remove(max);
                max--;

                boolean contains = hm.containsKey(max);
                if (contains) {
                    int val = hm.get(max);
                    val = val + maxCount;
                    hm.replace(max, val);
                } else {
                    hm.put(max, maxCount);
                }
                // }
            }
        }

        return max - min;
    }

    // public static int minimizeDiff(ArrayList<Integer> A, int B) {
    // int len = A.size();

    // Collections.sort(A);

    // while (B > 0) {
    // if (A.get(A.size() - 1) - A.get(0) == 0) break;

    // int countEqualFront = 0;
    // int countEqualBack = 0;

    // for (int i = 0; i < len - 1; i++) {
    // int curr = A.get(i);
    // int next = A.get(i+1);
    // if (curr == next) {
    // countEqualFront++;
    // } else {
    // break;
    // }
    // }
    // for (int i = len -1; i >= 1; i--) {
    // int curr = A.get(i);
    // int prev = A.get(i - 1);
    // if (curr == prev) {
    // countEqualBack++;
    // } else {
    // break;
    // }
    // }

    // if (countEqualFront <= countEqualBack) {
    // for (int i = 0; i < len - 1; i++) {
    // int curr = A.get(i);
    // int next= A.get(i+1);

    // if (curr < next) {
    // curr++;
    // A.set(i, curr);
    // B--;
    // break;
    // }
    // }
    // continue;
    // }

}
