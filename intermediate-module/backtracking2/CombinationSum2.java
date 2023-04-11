package backtracking2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int B = 8;
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(combinationSum(A, B));
    }
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int[] x = new int[A.size()];
        HashSet<String> set = new HashSet<>();
        backtrack(A, B, 0, x, set);

        int len = result.size() - 1;
        for (int i = len; i >= len / 2; i--) {
            int last = len - i;
            ArrayList<Integer> temp = result.get(i);
            result.set(i, result.get(last));
            result.set(last, temp);
        }
        return result;
    }
    public static void backtrack(ArrayList<Integer> A, int B, int i, int[] x, HashSet<String> set) {
        if (i >= A.size()) {
            int sum = 0;
            ArrayList<Integer> innerList = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < x.length; j++) {
                if (x[j] == 1) {
                    sum += A.get(j);
                    innerList.add(A.get(j));
                    str.append(A.get(j));
                }
            }
            String y = new String(str);
            if (sum == B && !set.contains(y)) {
                set.add(y);
                result.add(innerList);
            }
            return;
        }
        x[i] = 0;
        backtrack(A, B, i + 1, x, set);
        x[i] = 1;
        backtrack(A, B, i + 1, x, set);
    }
}
