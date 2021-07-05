import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
    public static void main(String args[]) {
        // int[] arr = { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52,
        // 23, 74, 81, 42, 28, 16, 66, 35, 91,
        // 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26,
        // 81, 92 };
        int[] arr = { 2, 1, 4, 3 };
        // int[] arr = { 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A));
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        for (int i = 0; i < len - 1; i += 2) {
            int curr = A.get(i);
            int next = A.get(i + 1);
            A.set(i, next);
            A.set(i + 1, curr);
        }
        return A;
    }
}
