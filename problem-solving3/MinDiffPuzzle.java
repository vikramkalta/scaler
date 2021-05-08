import java.util.ArrayList;
import java.util.Collections;

public class MinDiffPuzzle {
    public static void main(String args[]) {
        int[] arr = {10, 12, 10, 7, 5, 22};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(minDiffPuzzles(A, 4));
    }

    public static int minDiffPuzzles(ArrayList<Integer> A, int B) {
        int len = A.size();

        Collections.sort(A);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - B + 1; i++) {
            int _min = A.get(i);
            int _max = A.get(B + i - 1);
            int diff= _max - _min;
            if (min > diff) {
                min = diff;
            }
        }
        return min;
    }
}
