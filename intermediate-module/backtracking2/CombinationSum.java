package backtracking2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CombinationSum {
    public static void main(String[] args) {
        int[] a = { 2, 3, 6, 6, 7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(combinationSum(A, 7));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            set.put(A.get(i), 1);
        }
        ArrayList<Integer> newList = new ArrayList<>();
        for (int key: set.keySet()) {
            newList.add(key);
        }
        Collections.sort(newList);
        sum(newList, B, 0, 0, result, new ArrayList<>());
        return result;
    }
    public static void sum(ArrayList<Integer> A, int B, int i, int sum, ArrayList<ArrayList<Integer>> result,
    ArrayList<Integer> runningSumList) {
        if (sum >= B) {
            if (sum == B) {
                result.add(new ArrayList<>(runningSumList));
            }
            return;
        }
        for (int j = i; j < A.size(); j++) {
            sum += A.get(j);
            runningSumList.add(A.get(j));
            sum(A, B, j, sum, result, runningSumList);
            sum -= A.get(j);
            runningSumList.remove(runningSumList.size() - 1);
        }
    }

    public static void sum1(ArrayList<Integer> A, int B, int i, int sum, ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> runningSumList) {
        if (sum >= B) {
            if (sum == B) {
                for (int k = 0; k < runningSumList.size(); k++) {
                    System.out.print(runningSumList.get(k));
                }
                // System.out.println(runningSumList);
                result.add(new ArrayList<>(runningSumList));
            }
            return;
        }
        if (i >= A.size()) {
            return;
        }
        sum += A.get(i);
        runningSumList.add(A.get(i));
        sum(A, B, i, sum, result, runningSumList);
        sum(A, B, i + 1, sum, result, runningSumList);
        sum -= A.get(i);
        runningSumList.remove(runningSumList.size() - 1);
    }
}
