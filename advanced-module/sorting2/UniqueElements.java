import java.util.ArrayList;
import java.util.Collections;

public class UniqueElements {
    public static void main(String args[]) {
        // int[] arr = { 1, 1, 3 };
        int[] arr = { 51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97,
                100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86,
                48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22,
                25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62 };
        // int[] arr = { 927, 707, 374, 394, 279, 799, 878, 937, 431, 112 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        int prev = A.get(0);
        int count = 0;
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            while (curr <= prev) {
                curr++;
                count++;
            }
            A.set(i, curr);
            prev = curr;
        }
        // System.out.println(A);
        return count;
    }
}
