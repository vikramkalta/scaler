import java.util.ArrayList;
import java.util.Collections;

public class GameOfBottles {
    public static void main(String args[]) {
        // int[] arr = { 3, 2, 1 };
        // int[] arr = { 1, 1 };
        int[] arr = { 8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3, 8, 17, 12, 5, 3, 14, 13, 3, 2, 17, 19,
                16, 8, 7, 12, 19, 10, 13, 8, 20, 16, 15, 4, 12, 3 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        // int prev = A.get(0);
        // int count = 0;
        for (int i = 0; i < A.size(); i++) {
            int curr = A.get(i);
            for (int j = i + 1; j < A.size(); j++) {
                int currJ = A.get(j);
                if (currJ > curr) {
                    A.remove(i);
                    i--;
                    break;
                }
            }
        }
        return A.size();
    }
}
