import java.util.ArrayList;

public class KnapSack {
    public static void main(String args[]) {
        int[] a = { 2, 3, 1, 4, 5 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        ArrayList<Integer> subSequencesList = new ArrayList<>();
        int[] arr = new int[a.length];
        subSequences(A, 0, subSequencesList, arr);
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        return 0;
    }

    public static int knapsack(ArrayList<Integer> A, ArrayList<Integer> B, int sum, int C, int index) {
        if (sum > C) {
            return sum;
        }
        sum += A.get(index);
        knapsack(A, B, sum, C, index);
        knapsack(A, B, sum, C, index + 1);
        sum -= A.get(index);
        return sum;
    }

    public static void subSequences(ArrayList<Integer> originalArr, int index, ArrayList<Integer> result,
            int[] auxArr) {
        if (index > originalArr.size()) {
            return;
        }
        auxArr[index] = 0;
        subSequences(originalArr, index + 1, result, auxArr);
        subSequences(originalArr, index + 1, result, auxArr);
        auxArr[index] = 1;
    }
}
