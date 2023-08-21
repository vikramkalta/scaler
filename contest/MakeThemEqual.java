import java.util.ArrayList;

public class MakeThemEqual {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3 };
        int[] arr = { 3, 1, 1, 3 };
        // int[] arr = { 2, 2, 2 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (min > curr) {
                min = curr;
            }
            if (max < curr) {
                max = curr;
            }
        }
        if (max == min) {
            return 0;
        }
        int i = 0;
        int count = 0;
        while (i < len) {
            int curr = A.get(i);
            while (curr > min) {
                curr >>= 1;
                if (min > curr) {
                    min = curr;
                }
                count++;
            }
            A.set(i, curr);

            if (i > 0 && curr != A.get(i - 1)) {
                i = 0;
            } else {
                i++;
            }
        }

        return count;
    }
}
