import java.util.ArrayList;

public class Test {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 7 };
        int[] arr = { 2, 3, 4, 15, 9 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(solve(A, 6));
        System.out.println(solve(A, 8));
    }

    private static ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    public static void subseq(ArrayList<Integer> A, int i, int j, int[] aux) {
        if (i >= A.size()) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int index = 0; index < aux.length; index++) {
                if (aux[index] == 1) {
                    subset.add(A.get(index));
                }
            }
            results.add(subset);
            return;
        }
        aux[i] = 0;
        subseq(A, i + 1, j, aux);
        aux[i] = 1;
        subseq(A, i + 1, j, aux);
    }

    public static boolean solve1(ArrayList<Integer> A, int sum) {
        int[] aux = new int[A.size()];
        subseq(A, 0, 0, aux);
        for (int i = 0; i < results.size(); i++) {
            ArrayList<Integer> subset = results.get(i);
            int s = 0;
            for (int j = 0; j < subset.size(); j++) {
                int curr = subset.get(j);
                s += curr;
            }
            if (s == sum) {
                return true;
            }
        }
        return false;
    }

    public static boolean solve(ArrayList<Integer> A, int sum) {
        ArrayList<ArrayList<Boolean>> dp = new ArrayList<>();
        int rows = A.size() + 1;
        int cols = sum + 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Boolean> innerList = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                innerList.add(false);
            }
            dp.add(innerList);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println(dp.get(i));
                if (j == 0) {
                    dp.get(i).set(j, true);
                } else if (i == 0 && j >= 1) {
                    dp.get(i).set(j, false);
                } else if (dp.get(i-1).get(j)) {
                    dp.get(i).set(j, true);
                } else {
                    int value = A.get(i - 1);
                    if (j >= value && dp.get(i - 1).get(j - value)) {
                        dp.get(i).set(j, true);
                    }
                }
            }
        }
        return dp.get(rows - 1).get(cols - 1);
    }
}

// Given an array of non-negative integers, and a value sum, determine if there
// is a subset of the given set with sum equal to given sum.
// Your Task:
// return boolean value true if there exists a subset with given sum and false
// otherwise.
// The driver code itself prints 1, if returned value is true and prints 0 if
// returned value is false.
// Example 1:
// Input:N = 6arr[] = {3, 34, 4, 12, 5, 2}sum = 9Output: 1 Explanation: Here
// there exists a subset withsum = 9, 4+3+2 = 9.
// Example 2:
// Input:N
// Example 2:

// Input:N = 6arr[] = {3, 34, 4, 12, 5, 2}sum = 30Output: 0 Explanation: There
// is no subset with sum 30.

// Expected Time Complexity: O(sum*N)
// Expected Auxiliary Space: O(sum*N)

// Constraints:
// 1 <= N <= 100
// 1<= arr[i] <= 100
// 1<= sum <= 105

// 1,2,3,7 , 6
// 1,
// 2,
// 3,
// 1,2,
// 1,3,
// 1,7,
// 1,2,3
// {}