import java.util.ArrayList;

public class SumDifference {
    public static void main(String args[]) {
        int[] arr = {1,2,3};
        // int[] arr = {1,2};
        // int[] arr = {1};
        // int[] arr = {5, 4, 2};
        // int[] arr = {5, 4, 3, 2};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(sumDiff(A));
    }

    public static int sumDiff(ArrayList<Integer> A) {
        int len = A.size();

        int sum = 0;
        ArrayList<Integer> subSequences = new ArrayList<>();
        printSubsequence(subSequences, 0, len, A);

        return sum;
    }

    public static void printSubsequence(ArrayList<Integer> t, int i, int n, ArrayList<Integer> A) {
        if (i == n) {
            System.out.println(t);
            t.clear();
        } else {
            printSubsequence(t, i+1, n, A);
            t.add(A.get(i));
        }
    }

    // public static void printSubsequence(ArrayList<Integer> t, int i, int n, ArrayList<Integer> A) {
    //     if (i == n) {
    //         System.out.println(t);
    //         t.clear();
    //     } else {
    //         printSubsequence(t, i+1, n, A);
    //         t.add(A.get(i));
    //         // t=t+A.get(i);
    //         printSubsequence(t, i+1, n, A);
    //     }
    // }
}
