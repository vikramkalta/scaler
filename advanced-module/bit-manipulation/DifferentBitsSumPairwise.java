import java.util.ArrayList;

public class DifferentBitsSumPairwise {
    public static void main(String args[]) {
        // int[] arr = { 1, 3, 5 };
        int[] arr = { 1, 3, 5, 7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();

        int countDiff = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int currI = A.get(i);
                int currJ = A.get(j);
                int iter = 0;
                while (iter < 32) {
                    if (((currI & 1) == 1 && (currJ & 1) == 0) || ((currI & 1) == 0 && (currJ & 1) == 1)) {
                        countDiff++;
                    }
                    currI >>= 1;
                    currJ >>= 1;
                    iter++;
                }
            }
        }

        return countDiff * 2;
    }
}
