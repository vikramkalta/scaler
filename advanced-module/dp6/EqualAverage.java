import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EqualAverage {
    public static void main(String args[]) {
        // int[] A = {1,7,15,29,11,9};
        // int[] A = { 10, 20, 30, 40 };
        int[] A = {40, 49, 96, 23, 18, 45, 46, 51, 21, 55, 79, 88, 64, 28, 41, 50};
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < A.length; i++)
            B.add(A[i]);
        System.out.println(avgset(B));
    }

    public static ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> B) {
        int len = B.size();
        int[] A = new int[len];
        for (int i = 0; i < len; i++)
            A[i] = B.get(i);
        int sum = 0;
        Arrays.sort(A);
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int s1 = 0;
        boolean[][][] dp = new boolean[len][sum+1][len+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < sum+1; j++) {
                for (int k = 0; k < len+1; k++) {
                    dp[i][j][k] = true;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            int a = (i + 1) * sum;
            if (isEvenlyDivisible(a, len)) {
                s1 = a / len;
                int[] indices = new int[len];
                ArrayList<Integer> temp = new ArrayList<>();
                // int[][][] dp = new int[len+1][s1+1][s1+1];
                // boolean[][][] dp = new boolean[len][s1+1][i+2];
                if (_check(0, s1, i + 1, A, dp)) {
                    return result;
                }
                
                // if (check(A, i + 1, s1, indices, 0, 0, 0, temp, dp)) {
                //     result.clear();
                //     ArrayList<Integer> arr1 = new ArrayList<>();
                //     ArrayList<Integer> arr2 = new ArrayList<>();
                //     HashMap<Integer, Integer> indexMap = new HashMap<>();
                //     for (int j = 0; j < temp.size(); j++) {
                //         int currIndex = temp.get(j);
                //         arr1.add(A[currIndex]);
                //         indexMap.put(currIndex, 0);
                //     }
                //     for (int j = 0; j < len; j++) {
                //         if (!indexMap.containsKey(j)) {
                //             arr2.add(A[j]);
                //         }
                //     }
                //     if (arr1.size() > arr2.size()) {
                //         result.add(arr2);
                //         result.add(arr1);
                //     } else if (arr1.size() == arr2.size()) {
                //         for (int j = 0; j < arr1.size(); j++) {
                //             if (arr1.get(j) > arr2.get(j)) {
                //                 result.add(arr2);
                //                 result.add(arr1);
                //                 break;
                //             } else if (arr1.get(j).equals(arr2.get(j))) {
                //                 result.add(arr2);
                //                 result.add(arr1);
                //             } else {
                //                 result.add(arr1);
                //                 result.add(arr2);
                //                 break;
                //             }
                //         }
                //     } else {
                //         result.add(arr1);
                //         result.add(arr2);
                //     }
                //     return result;
                // }
            }
        }
        return result;
    }
    public static boolean _check(int ind, int sum, int element, int[] A, boolean[][][] dp) {
        if (element == 0) return sum == 0;
        if (ind >= A.length) return false;
        if (dp[ind][sum][element] == false)
            return false;
        if (A[ind]<=sum) {
            if (_check(ind + 1, sum - A[ind], element - 1, A, dp)) {
                dp[ind][sum][element] = true;
                return true;
            }
        }
        if (_check(ind + 1, sum, element, A, dp)) {
            dp[ind][sum][element] = true;
            return true;
        }
        dp[ind][sum][element] = false;
        return false;
    }

    public static boolean check(int[] A, int totalElements, int capacity, int[] indices, int totalSum,
            int totalCollectedElements, int index, ArrayList<Integer> temp, int[][][] dp) {
        if (totalCollectedElements > totalElements || totalSum > capacity || index >= A.length) {
            return false;
        }
        if (totalCollectedElements == totalElements && totalSum == capacity) {
            // temp.clear();
            if (temp.isEmpty()) {
                ArrayList<Integer> test = new ArrayList<>();
                for (int i = 0; i < A.length; i++) {
                    if (indices[i] == 1) {
                        temp.add(i);
                        test.add(A[i]);
                    }
                }
                // System.out.println(test);
            }
            return true;
        }
        if (dp[index][totalSum][totalCollectedElements] != 0) {
            return dp[index][totalSum][totalCollectedElements] == 1 ? true : false;
        } 
        // Take the element
        indices[index] = 1;
        boolean x = check(A, totalElements, capacity, indices, totalSum + A[index], totalCollectedElements + 1,
                index + 1, temp, dp);
        // Leave the element
        indices[index] = 0;
        boolean y = false;
        if (!x) {
            y = check(A, totalElements, capacity, indices, totalSum, totalCollectedElements, index + 1, temp, dp);
        }
        dp[index][totalSum][totalCollectedElements] = x || y ? 1 : -1;
        return x || y;
    }

    public static boolean isEvenlyDivisible(int a, int b) {
        return a % b == 0;
    }
}
