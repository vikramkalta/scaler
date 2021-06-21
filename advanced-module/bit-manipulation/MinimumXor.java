import java.util.ArrayList;

public class MinimumXor {
    public static void main(String args[]) {
        // int[] arr = { 0, 2, 5, 7 };
        int[] arr = { 0, 4, 7, 9 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int min = Integer.MAX_VALUE;
        int xor = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            xor ^= curr;
            if (min > xor) {
                min = xor;
            }
        }
        return min;
    }

    public static int solve1(ArrayList<Integer> A) {
        int len = A.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int currI = A.get(i);
                int currJ = A.get(j);
                // int iter = 0;
                int xor = currI ^ currJ;
                if (xor < min) {
                    min = xor;
                }
                // while(iter < 32) {
                // // if ()
                // currI >>= 1;
                // currJ >>= 1;
                // iter++;
                // }
            }
        }
        return min;
    }
}
