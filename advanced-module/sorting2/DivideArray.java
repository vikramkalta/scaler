import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DivideArray {
    public static void main(String args[]) {
        // int[] arr = { 3, 11, -1, 5 };
        int[] arr = { 98, 83, 54, 57, 36, 83, 7, 98, -3, 37 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A));
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        long mod = 1000000007l;
        Collections.sort(A);

        long maxDiffSum = 0l, minDiffSum = 0l;
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            long curr = 1l * A.get(i);
            long rev = 1l * A.get(len - 1 - i);
            long diff = 1l * (Math.abs(curr - rev));
            maxDiffSum += diff;

            int indexToFetch = i * 2;
            long currMin = 1l * A.get(indexToFetch);
            long currNextMin = 1l * A.get(indexToFetch + 1);
            long diffMin = 1l * (Math.abs(currMin - currNextMin));
            minDiffSum += diffMin;
        }
        maxDiffSum %= mod;
        if (maxDiffSum < 0)
            maxDiffSum += mod;
        minDiffSum %= mod;
        if (minDiffSum < 0)
            minDiffSum += mod;
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) maxDiffSum);
        result.add((int) minDiffSum);
        return result;
    }
}
