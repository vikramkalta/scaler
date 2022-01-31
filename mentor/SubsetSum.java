import java.util.ArrayList;

public class SubsetSum {
    public static void main(String args[]) {
        int[] arr = {1,2,3,7};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(solve(A, 6));
    }

    public static ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

    public static boolean solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> innerList =new ArrayList<>();
            for (int j = 0; j < B + 1; j++) {
                innerList.add(-1);
            }
            dp.add(innerList);
        }
        int[] aux = new int[len];
        getSubsequences(A, 0, aux, B, 0);
        for (int i = 0, slen = subsets.size(); i < slen; i++) {
            System.out.println(subsets.get(i));
        }
        boolean ans = false;
        return ans;
    }

    public static void getSubsequences(ArrayList<Integer> A, int index, int[] aux, int B, int sum) {
        if (index >= A.size()) {
            // dp.get(index).set(sum, sum);
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] == 1) {
                    subset.add(A.get(i));
                }
            }
            subsets.add(subset);
            return;
        }
        // if (B >= sum) {
        //     dp.get(index).set(sum, sum);
        // }
        int _sum = 0;
        aux[index] = 0;
        getSubsequences(A, index + 1, aux, B, sum);
        aux[index] = 1;
        getSubsequences(A, index + 1, aux, B, sum + A.get(index));
        _sum += A.get(index);
    }
}
