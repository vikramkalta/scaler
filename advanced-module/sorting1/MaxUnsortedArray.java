import java.util.ArrayList;

public class MaxUnsortedArray {
    public static void main(String args[]) {
        // int[] arr = { 1, 3, 2, 4, 5 };
        // int[] arr = { 1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20,
        // 20 };
        // int[] arr = { 4, 15, 4, 4, 15, 18, 20 };
        // int[] arr = { 1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17,
        // 19, 19 };
        // int[] arr = { 1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14,
        // 19, 18 };
        // int[] arr = { 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 };
        // int[] arr = { 1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14,
        // 19, 18 };
        int[] arr = { 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A));
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        int start = -1, end = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIndex = -1, tracker = -1;
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            int prev = A.get(i - 1);
            if (max < prev) {
                max = prev;
            }
            if (curr < prev && start == -1) {
                min = curr;
                int x = 0;
                for (int j = 0; j < i; j++) {
                    int currJ = A.get(j);
                    if (currJ <= curr) {
                        x++;
                    }
                }
                start = x;
                minIndex = x;
                tracker = i;
                // start = i - 1;
            }
            if (start != -1 && A.get(tracker) > curr) {
                min = curr;
                int x = 0;
                for (int j = 0; j < i; j++) {
                    int currJ = A.get(j);
                    if (currJ <= curr) {
                        x++;
                    }
                }
                start = x;
                minIndex = x;
                tracker = i;
            }
            if (start != -1 && start != minIndex && A.get(start) == min) {
                start++;
            }
            if (curr < max && start != -1) {
                end = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(start);
        if (end != -1) {
            result.add(end);
        }

        return result;
    }
}
